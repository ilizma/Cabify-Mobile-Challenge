package com.ilizma.marketplace.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilizma.marketplace.domain.model.ArticlesCheckoutInfo
import com.ilizma.marketplace.domain.model.ArticlesState
import com.ilizma.marketplace.domain.usecase.GetArticlesCheckoutInfoUseCase
import com.ilizma.marketplace.domain.usecase.GetArticlesStateUseCase
import com.ilizma.marketplace.presentation.mapper.ArticlesCheckoutInfoMapper
import com.ilizma.marketplace.presentation.mapper.ArticlesStateMapper
import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.presentation.model.CheckoutState
import com.ilizma.marketplace.presentation.model.MarketplaceNavigationAction
import com.ilizma.marketplace.presentation.model.MarketplaceNavigationAction.Back
import com.ilizma.marketplace.presentation.model.MarketplaceNavigationAction.Checkout
import com.ilizma.marketplace.presentation.viewmodel.factory.CHECKOUT_STATE_ASSISTED
import com.ilizma.marketplace.presentation.viewmodel.factory.ERROR_ASSISTED
import com.ilizma.presentation.SingleLiveEvent
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import com.ilizma.marketplace.presentation.model.ArticlesState as PresentationArticlesState

class MarketplaceViewModelImp @AssistedInject constructor(
    private val getArticlesStateUseCase: GetArticlesStateUseCase,
    private val getArticlesCheckoutInfoUseCase: GetArticlesCheckoutInfoUseCase,
    @Assisted private val articlesStateMapper: ArticlesStateMapper,
    @Assisted private val articlesCheckoutInfoMapper: ArticlesCheckoutInfoMapper,
    @Assisted private val backgroundScheduler: Scheduler,
    @Assisted private val compositeDisposable: CompositeDisposable,
    @Assisted private val _state: MutableLiveData<PresentationArticlesState>,
    @Assisted(ERROR_ASSISTED) private val _error: MutableLiveData<String>,
    @Assisted(CHECKOUT_STATE_ASSISTED) private val _checkoutState: MutableLiveData<CheckoutState>,
    @Assisted private val _navigationAction: SingleLiveEvent<MarketplaceNavigationAction>,
) : MarketplaceViewModel() {

    override val state: LiveData<PresentationArticlesState> = _state
    override val error: LiveData<String> = _error
    override val checkoutState: LiveData<CheckoutState> = _checkoutState
    override val navigationAction: LiveData<MarketplaceNavigationAction> = _navigationAction

    init {
        getState()
    }

    override fun getState() {
        generateLoadingList()
            .let { PresentationArticlesState.Loading(it) }
            .let { _state.postValue(it) }

        getArticlesStateUseCase()
            .subscribeOn(backgroundScheduler)
            .observeOn(backgroundScheduler)
            .subscribe(::onArticlesState) { throw it }
            .addTo(compositeDisposable)
    }

    override fun onCheckout() {
        _checkoutState.postValue(CheckoutState.LOADING)
        getArticlesCheckoutInfoUseCase()
            .subscribeOn(backgroundScheduler)
            .observeOn(backgroundScheduler)
            .subscribe(::onArticlesCheckoutInfo) { throw it }
            .addTo(compositeDisposable)
    }

    override fun onBack() {
        _navigationAction.postValue(Back)
    }

    private fun onArticlesState(
        state: ArticlesState,
    ) {
        when (state) {
            is ArticlesState.RemoteError -> _error.postValue(state.message)
            is ArticlesState.Success -> articlesStateMapper.from(state)
                .let { _state.postValue(it) }
        }
    }

    private fun onArticlesCheckoutInfo(
        articlesCheckoutInfo: ArticlesCheckoutInfo,
    ) {
        articlesCheckoutInfoMapper.from(articlesCheckoutInfo)
            .let { Checkout(it) }
            .also { _checkoutState.postValue(CheckoutState.NONE) }
            .let { _navigationAction.postValue(it) }
    }

    private fun generateLoadingList(
    ): List<Article.Loading> = mutableListOf<Article.Loading>()
        .let { for (i in 0..15) it.add(Article.Loading); it }

}

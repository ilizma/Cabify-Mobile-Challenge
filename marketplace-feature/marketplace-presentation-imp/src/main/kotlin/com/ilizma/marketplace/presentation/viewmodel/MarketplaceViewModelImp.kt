package com.ilizma.marketplace.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilizma.marketplace.domain.model.ArticlesState
import com.ilizma.marketplace.domain.usecase.GetArticlesStateUseCase
import com.ilizma.marketplace.presentation.mapper.ArticlesStateMapper
import com.ilizma.marketplace.presentation.model.MarketplaceNavigationAction
import com.ilizma.marketplace.presentation.model.MarketplaceNavigationAction.CHECKOUT
import com.ilizma.marketplace.presentation.viewmodel.factory.ERROR_ASSISTED
import com.ilizma.presentation.SingleLiveEvent
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import com.ilizma.marketplace.presentation.model.ArticlesState as PresentationArticlesState

class MarketplaceViewModelImp @AssistedInject constructor(
    private val useCase: GetArticlesStateUseCase,
    @Assisted private val mapper: ArticlesStateMapper,
    @Assisted private val backgroundScheduler: Scheduler,
    @Assisted private val compositeDisposable: CompositeDisposable,
    @Assisted private val _state: MutableLiveData<PresentationArticlesState>,
    @Assisted(ERROR_ASSISTED) private val _error: MutableLiveData<String>,
    @Assisted private val _navigationAction: SingleLiveEvent<MarketplaceNavigationAction>,
) : MarketplaceViewModel() {

    override val state: LiveData<PresentationArticlesState> = _state
    override val error: LiveData<String> = _error
    override val navigationAction: LiveData<MarketplaceNavigationAction> = _navigationAction

    init {
        getState()
    }

    override fun onCheckout() {
        _navigationAction.postValue(CHECKOUT)
    }

    private fun getState() {
        useCase()
            .subscribeOn(backgroundScheduler)
            .observeOn(backgroundScheduler)
            .subscribe(::onArticlesState) { throw it }
            .addTo(compositeDisposable)
    }

    private fun onArticlesState(
        state: ArticlesState,
    ) {
        when (state) {
            is ArticlesState.RemoteError -> _error.postValue(state.message)
            is ArticlesState.Success -> mapper.from(state)
                .let { _state.postValue(it) }
        }
    }

}

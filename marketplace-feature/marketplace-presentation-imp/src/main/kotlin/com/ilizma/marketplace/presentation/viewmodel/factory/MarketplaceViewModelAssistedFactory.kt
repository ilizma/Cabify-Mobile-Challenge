package com.ilizma.marketplace.presentation.viewmodel.factory

import androidx.lifecycle.MutableLiveData
import com.ilizma.marketplace.presentation.mapper.ArticlesCheckoutInfoMapper
import com.ilizma.marketplace.presentation.mapper.ArticlesStateMapper
import com.ilizma.marketplace.presentation.model.ArticlesState
import com.ilizma.marketplace.presentation.model.CheckoutState
import com.ilizma.marketplace.presentation.model.MarketplaceNavigationAction
import com.ilizma.marketplace.presentation.viewmodel.MarketplaceViewModelImp
import com.ilizma.presentation.SingleLiveEvent
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable

const val ERROR_ASSISTED = "ERROR_ASSISTED"
const val CHECKOUT_STATE_ASSISTED = "CHECKOUT_STATE_ASSISTED"

@AssistedFactory
interface MarketplaceViewModelAssistedFactory {

    fun create(
        articlesStateMapper: ArticlesStateMapper,
        articlesCheckoutInfoMapper: ArticlesCheckoutInfoMapper,
        backgroundScheduler: Scheduler,
        compositeDisposable: CompositeDisposable,
        _state: MutableLiveData<ArticlesState>,
        @Assisted(ERROR_ASSISTED) _error: MutableLiveData<String>,
        @Assisted(CHECKOUT_STATE_ASSISTED) _checkoutState: MutableLiveData<CheckoutState>,
        _navigationAction: SingleLiveEvent<MarketplaceNavigationAction>,
    ): MarketplaceViewModelImp

}
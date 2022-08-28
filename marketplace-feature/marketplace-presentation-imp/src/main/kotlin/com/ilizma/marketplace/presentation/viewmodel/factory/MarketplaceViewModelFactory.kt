package com.ilizma.marketplace.presentation.viewmodel.factory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ilizma.marketplace.presentation.mapper.ArticleCheckoutInfoMapper
import com.ilizma.marketplace.presentation.mapper.ArticleMapper
import com.ilizma.marketplace.presentation.mapper.ArticlesCheckoutInfoMapper
import com.ilizma.marketplace.presentation.mapper.ArticlesStateMapper
import com.ilizma.marketplace.presentation.model.CheckoutState
import com.ilizma.presentation.SingleLiveEvent
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MarketplaceViewModelFactory(
    private val viewModelAssistedFactory: MarketplaceViewModelAssistedFactory,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>,
    ): T = viewModelAssistedFactory.create(
        articlesStateMapper = ArticlesStateMapper(
            mapper = ArticleMapper()
        ),
        articlesCheckoutInfoMapper = ArticlesCheckoutInfoMapper(
            mapper = ArticleCheckoutInfoMapper()
        ),
        backgroundScheduler = Schedulers.io(),
        compositeDisposable = CompositeDisposable(),
        _state = MutableLiveData(),
        _error = MutableLiveData(),
        _checkoutState = MutableLiveData(CheckoutState.NONE),
        _navigationAction = SingleLiveEvent(),
    ) as T

}
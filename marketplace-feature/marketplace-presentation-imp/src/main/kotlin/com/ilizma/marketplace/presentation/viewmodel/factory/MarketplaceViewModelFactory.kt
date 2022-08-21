package com.ilizma.marketplace.presentation.viewmodel.factory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ilizma.marketplace.presentation.mapper.ArticleMapper
import com.ilizma.marketplace.presentation.mapper.ArticlesStateMapper
import com.ilizma.presentation.SingleLiveEvent
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class MarketplaceViewModelFactory(
    private val viewModelAssistedFactory: MarketplaceViewModelAssistedFactory,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>,
    ): T = viewModelAssistedFactory.create(
        mapper = ArticlesStateMapper(ArticleMapper()),
        backgroundScheduler = Schedulers.io(),
        compositeDisposable = CompositeDisposable(),
        _state = MutableLiveData(),
        _error = MutableLiveData(),
        _navigationAction = SingleLiveEvent(),
    ) as T

}
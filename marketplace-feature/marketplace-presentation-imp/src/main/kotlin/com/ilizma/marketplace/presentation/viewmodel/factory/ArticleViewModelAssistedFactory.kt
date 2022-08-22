package com.ilizma.marketplace.presentation.viewmodel.factory

import androidx.lifecycle.MutableLiveData
import com.ilizma.marketplace.presentation.mapper.ArticleMapper
import com.ilizma.marketplace.presentation.viewmodel.ArticleViewModelImp
import dagger.assisted.AssistedFactory
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable

@AssistedFactory
interface ArticleViewModelAssistedFactory {

    fun create(
        mapper: ArticleMapper,
        backgroundScheduler: Scheduler,
        compositeDisposable: CompositeDisposable,
        _quantity: MutableLiveData<Int>,
    ): ArticleViewModelImp

}
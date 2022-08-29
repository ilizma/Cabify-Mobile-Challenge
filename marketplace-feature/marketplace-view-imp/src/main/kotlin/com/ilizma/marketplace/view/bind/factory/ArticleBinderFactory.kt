package com.ilizma.marketplace.view.bind.factory

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.presentation.viewmodel.ArticleViewModel
import com.ilizma.marketplace.presentation.viewmodel.factory.ArticleViewModelAssistedFactory
import com.ilizma.marketplace.view.bind.ArticleItemBinder
import com.ilizma.marketplace.view.bind.ArticleItemBinderImp
import com.ilizma.marketplace.view.bind.ArticleLoadingBinder
import com.ilizma.marketplace.view.bind.ArticleLoadingBinderImp
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class ArticleBinderFactory(
    private val viewModelAssistedFactory: ArticleViewModelAssistedFactory,
    private val lifecycleOwner: () -> LifecycleOwner,
) {

    fun createLoading(
    ): ArticleLoadingBinder = ArticleLoadingBinderImp()

    fun createItem(
    ): ArticleItemBinder<Article.Success> = ArticleItemBinderImp(
        viewModel = createViewModel(),
        lifecycleOwner = lifecycleOwner,
    )

    private fun createViewModel(
    ): ArticleViewModel = viewModelAssistedFactory.create(
        backgroundScheduler = Schedulers.io(),
        compositeDisposable = CompositeDisposable(),
        _quantity = MutableLiveData(),
    )

}
package com.ilizma.marketplace.view.bind.factory

import androidx.lifecycle.LifecycleOwner
import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.presentation.viewmodel.MarketplaceViewModel
import com.ilizma.marketplace.view.bind.ArticleItemBinder
import com.ilizma.marketplace.view.bind.ArticleItemBinderImp
import com.ilizma.marketplace.view.bind.ArticleLoadingBinder
import com.ilizma.marketplace.view.bind.ArticleLoadingBinderImp

class ArticleBinderFactory(
    private val viewModelLazy: Lazy<MarketplaceViewModel>,
    private val lifecycleOwnerLazy: () -> LifecycleOwner,
) {

    fun createLoading(
    ): ArticleLoadingBinder = ArticleLoadingBinderImp()

    fun createItem(
        onClicked: (Article.Success) -> Unit,
    ): ArticleItemBinder<Article.Success> = ArticleItemBinderImp(
        viewModel = viewModelLazy.value,
        onClicked = onClicked,
        lifecycleOwner = lifecycleOwnerLazy,
    )

}
package com.ilizma.marketplace.view.adapter.factory

import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.presentation.viewmodel.MarketplaceViewModel
import com.ilizma.marketplace.view.adapter.ArticlesAdapter
import com.ilizma.marketplace.view.adapter.ArticlesAdapterImp
import com.ilizma.marketplace.view.adapter.util.ArticleItemDiffUtil
import com.ilizma.marketplace.view.bind.factory.ArticleBinderFactory
import com.ilizma.marketplace.view.mapper.ArticleTypeMapper
import com.ilizma.marketplace.view.viewholder.factory.ArticleViewHolderFactory

class ArticlesAdapterFactoryImp(
    private val binderFactory: ArticleBinderFactory,
    private val diffUtil: ArticleItemDiffUtil<Article>,
    private val viewHolderFactory: ArticleViewHolderFactory,
    private val viewModelLazy: Lazy<MarketplaceViewModel>,
) : ArticlesAdapterFactory<Article> {

    override fun create(
    ): ArticlesAdapter<Article> = ArticlesAdapterImp(
        binderFactory = binderFactory,
        liveChannelItemDiffUtil = diffUtil,
        viewHolderFactory = viewHolderFactory,
        mapper = ArticleTypeMapper(),
        viewModel = viewModelLazy.value,
    )

}
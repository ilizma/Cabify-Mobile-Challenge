package com.ilizma.marketplace.view.adapter.factory

import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.view.adapter.Adapter
import com.ilizma.marketplace.view.adapter.ArticlesAdapterImp
import com.ilizma.view.adapter.util.ItemDiffUtil
import com.ilizma.marketplace.view.bind.factory.ArticleBinderFactory
import com.ilizma.marketplace.view.mapper.ArticleTypeMapper
import com.ilizma.marketplace.view.viewholder.factory.ArticleViewHolderFactory
import com.ilizma.view.adapter.factory.AdapterFactory

class ArticlesAdapterFactoryImp(
    private val binderFactory: ArticleBinderFactory,
    private val diffUtil: ItemDiffUtil<Article>,
    private val viewHolderFactory: ArticleViewHolderFactory,
) : AdapterFactory<Article> {

    override fun create(
    ): Adapter<Article> = ArticlesAdapterImp(
        binderFactory = binderFactory,
        liveChannelItemDiffUtil = diffUtil,
        viewHolderFactory = viewHolderFactory,
        mapper = ArticleTypeMapper(),
    )

}
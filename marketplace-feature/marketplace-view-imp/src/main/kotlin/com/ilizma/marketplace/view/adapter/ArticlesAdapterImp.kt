package com.ilizma.marketplace.view.adapter

import android.view.ViewGroup
import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.view.bind.factory.ArticleBinderFactory
import com.ilizma.marketplace.view.mapper.ArticleTypeMapper
import com.ilizma.marketplace.view.model.ArticleType.TYPE_ITEM
import com.ilizma.marketplace.view.model.ArticleType.TYPE_LOADING
import com.ilizma.marketplace.view.viewholder.factory.ArticleViewHolderFactory
import com.ilizma.view.adapter.Adapter
import com.ilizma.view.adapter.util.ItemDiffUtil
import com.ilizma.view.viewholder.ViewHolder

class ArticlesAdapterImp(
    private val binderFactory: ArticleBinderFactory,
    liveChannelItemDiffUtil: ItemDiffUtil<Article>,
    private val viewHolderFactory: ArticleViewHolderFactory,
    private val mapper: ArticleTypeMapper,
) : Adapter<Article>(liveChannelItemDiffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder<Article> = viewHolderFactory.create(
        binderFactory = binderFactory,
        parent = parent,
        type = mapper.from(viewType),
    )

    override fun onBindViewHolder(holder: ViewHolder<Article>, position: Int) {
        getItem(position).let { holder.bind(it) }
    }

    override fun onViewRecycled(holder: ViewHolder<Article>) {
        super.onViewRecycled(holder)
        holder.unBind()
    }

    override fun getItemViewType(
        position: Int,
    ): Int = when (getItem(position)) {
        is Article.Loading -> TYPE_LOADING.ordinal
        else -> TYPE_ITEM.ordinal
    }

}

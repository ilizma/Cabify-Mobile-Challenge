package com.ilizma.marketplace.view.viewholder.factory

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.view.bind.factory.ArticleBinderFactory
import com.ilizma.marketplace.view.databinding.ArticleItemBinding
import com.ilizma.marketplace.view.databinding.ArticleLoadingBinding
import com.ilizma.marketplace.view.model.ArticleType
import com.ilizma.marketplace.view.viewholder.ArticleItemViewHolderImp
import com.ilizma.marketplace.view.viewholder.ArticleLoadingViewHolderImp
import com.ilizma.marketplace.view.viewholder.ArticleViewHolder

class ArticleViewHolderFactory {

    fun create(
        binderFactory: ArticleBinderFactory,
        parent: ViewGroup,
        type: ArticleType,
    ): ArticleViewHolder<Article> = LayoutInflater.from(parent.context)
        .let { viewHolder(binderFactory, type, it, parent) }

    private fun viewHolder(
        binderFactory: ArticleBinderFactory,
        type: ArticleType,
        inflater: LayoutInflater,
        parent: ViewGroup,
    ): ArticleViewHolder<Article> = when (type) {
        ArticleType.TYPE_LOADING -> ArticleLoadingBinding.inflate(inflater, parent, false)
            .let { ArticleLoadingViewHolderImp(binderFactory.createLoading(), it) }
        ArticleType.TYPE_ITEM -> ArticleItemBinding.inflate(inflater, parent, false)
            .let { ArticleItemViewHolderImp(binderFactory.createItem(), it) }
        else -> throw IllegalArgumentException("Invalid Article viewType: $type")
    }

}
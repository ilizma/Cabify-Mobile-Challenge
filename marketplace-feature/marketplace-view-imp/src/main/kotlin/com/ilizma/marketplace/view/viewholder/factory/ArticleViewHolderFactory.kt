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
import com.ilizma.view.viewholder.ViewHolder

class ArticleViewHolderFactory {

    fun create(
        binderFactory: ArticleBinderFactory,
        parent: ViewGroup,
        type: ArticleType,
    ): ViewHolder<Article> = LayoutInflater.from(parent.context)
        .let { viewHolder(binderFactory, type, it, parent) }

    private fun viewHolder(
        binderFactory: ArticleBinderFactory,
        type: ArticleType,
        inflater: LayoutInflater,
        parent: ViewGroup,
    ): ViewHolder<Article> = when (type) {
        ArticleType.TYPE_LOADING -> ArticleLoadingBinding.inflate(inflater, parent, false)
            .let { ArticleLoadingViewHolderImp(binder = binderFactory.createLoading(), binding = it) }
        ArticleType.TYPE_ITEM -> ArticleItemBinding.inflate(inflater, parent, false)
            .let { ArticleItemViewHolderImp(binder = binderFactory.createItem(), binding = it) }
        else -> throw IllegalArgumentException("Invalid Article viewType: $type")
    }

}
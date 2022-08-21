package com.ilizma.marketplace.view.adapter.util

import com.ilizma.marketplace.presentation.model.Article

class ArticleItemDiffUtilImp : ArticleItemDiffUtil<Article>() {

    override fun areItemsTheSame(
        oldItem: Article,
        newItem: Article,
    ): Boolean = when (oldItem) {
        Article.Loading -> newItem is Article.Loading
        is Article.Success -> if (newItem is Article.Success.Mug) oldItem.name == newItem.name else false
    }

    override fun areContentsTheSame(
        oldItem: Article,
        newItem: Article,
    ): Boolean = oldItem == newItem

} 
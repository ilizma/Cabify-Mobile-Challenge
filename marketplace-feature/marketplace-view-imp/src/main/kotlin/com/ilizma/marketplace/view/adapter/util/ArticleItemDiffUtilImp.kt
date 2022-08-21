package com.ilizma.marketplace.view.adapter.util

import com.ilizma.marketplace.presentation.model.Article

class ArticleItemDiffUtilImp : ArticleItemDiffUtil<Article>() {

    override fun areItemsTheSame(
        oldItem: Article,
        newItem: Article,
    ): Boolean = oldItem.name == newItem.name

    override fun areContentsTheSame(
        oldItem: Article,
        newItem: Article,
    ): Boolean = oldItem == newItem

} 
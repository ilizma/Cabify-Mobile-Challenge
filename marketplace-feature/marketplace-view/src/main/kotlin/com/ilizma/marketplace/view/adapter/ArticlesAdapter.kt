package com.ilizma.marketplace.view.adapter

import androidx.recyclerview.widget.ListAdapter
import com.ilizma.marketplace.view.adapter.util.ArticleItemDiffUtil
import com.ilizma.marketplace.view.viewholder.ArticleViewHolder

abstract class ArticlesAdapter<T>(
    diffUtil: ArticleItemDiffUtil<T>,
) : ListAdapter<T, ArticleViewHolder<T>>(
    diffUtil,
)
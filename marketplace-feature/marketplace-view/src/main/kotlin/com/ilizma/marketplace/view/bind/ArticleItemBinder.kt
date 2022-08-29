package com.ilizma.marketplace.view.bind

import com.ilizma.marketplace.view.databinding.ArticleItemBinding

interface ArticleItemBinder<T> {

    fun bind(binding: ArticleItemBinding, article: T)

    fun unBind()

}
package com.ilizma.marketplace.view.viewholder

import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.view.bind.ArticleLoadingBinder
import com.ilizma.marketplace.view.databinding.ArticleLoadingBinding

class ArticleLoadingViewHolderImp(
    private val binder: ArticleLoadingBinder,
    private val binding: ArticleLoadingBinding,
) : ArticleViewHolder<Article>(binding.root) {

    override fun bind(article: Article, position: Int) {
        binder.bind(binding)
    }

    override fun unBind() {
        binder.unBind()
    }

}
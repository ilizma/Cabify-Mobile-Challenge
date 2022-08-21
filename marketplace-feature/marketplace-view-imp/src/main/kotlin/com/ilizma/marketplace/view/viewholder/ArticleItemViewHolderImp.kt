package com.ilizma.marketplace.view.viewholder

import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.view.bind.ArticleItemBinder
import com.ilizma.marketplace.view.databinding.ArticleItemBinding

class ArticleItemViewHolderImp(
    private val binder: ArticleItemBinder<Article.Success>,
    private val binding: ArticleItemBinding,
) : ArticleViewHolder<Article>(binding.root) {

    override fun bind(article: Article, position: Int) {
        binder.bind(position, binding, article as Article.Success)
    }

    override fun unBind() {
        binder.unBind()
    }

}
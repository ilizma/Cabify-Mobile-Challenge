package com.ilizma.marketplace.view.bind

import com.ilizma.marketplace.view.databinding.ArticleLoadingBinding

class ArticleLoadingBinderImp : ArticleLoadingBinder {

    private lateinit var binding: ArticleLoadingBinding

    override fun bind(
        binding: ArticleLoadingBinding,
    ) {
        this.binding = binding
        binding.articleLoadingSfl.startShimmer()
    }

    override fun unBind() {
        binding.articleLoadingSfl.stopShimmer()
    }


}
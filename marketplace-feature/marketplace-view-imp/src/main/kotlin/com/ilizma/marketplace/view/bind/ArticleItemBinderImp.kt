package com.ilizma.marketplace.view.bind

import androidx.lifecycle.LifecycleOwner
import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.presentation.viewmodel.ArticleViewModel
import com.ilizma.marketplace.view.databinding.ArticleItemBinding
import com.ilizma.view.extensions.setOnReactiveClickListener

class ArticleItemBinderImp(
    private val viewModel: ArticleViewModel,
    private val lifecycleOwner: () -> LifecycleOwner,
) : ArticleItemBinder<Article.Success> {

    private lateinit var binding: ArticleItemBinding

    override fun bind(binding: ArticleItemBinding, article: Article.Success) {
        this.binding = binding
        viewModel.getArticleQuantity(article)
        setupObservers()
        setupView(binding, article)
    }

    override fun unBind() {
        binding.articleItemTvPlus.setOnReactiveClickListener { /* Do nothing */ }
        binding.articleItemTvMinus.setOnReactiveClickListener { /* Do nothing */ }
    }

    private fun setupObservers() {
        viewModel.quantity.observe(
            lifecycleOwner(),
            ::onQuantity,
        )
    }

    private fun setupView(
        binding: ArticleItemBinding,
        article: Article.Success,
    ) {
        binding.articleItemTvName.text = article.name
        when (article) {
            is Article.Success.TShirt -> article.discountDescription
            is Article.Success.Voucher -> article.discountDescription
            is Article.Success.Mug -> ""
        }.let { binding.articleItemTvDescription.text = it }
        binding.articleItemTvPrice.text = article.price
        binding.articleItemTvPlus.setOnReactiveClickListener { viewModel.onPlus(article) }
        binding.articleItemTvMinus.setOnReactiveClickListener { viewModel.onMinus(article) }
    }

    private fun onQuantity(
        quantity: Int,
    ) {
        binding.articleItemTvQuantity.text = quantity.toString()
    }

}
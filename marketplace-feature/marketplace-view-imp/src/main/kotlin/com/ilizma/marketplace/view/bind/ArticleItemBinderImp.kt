package com.ilizma.marketplace.view.bind

import androidx.lifecycle.LifecycleOwner
import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.presentation.viewmodel.MarketplaceViewModel
import com.ilizma.marketplace.view.databinding.ArticleItemBinding
import com.ilizma.view.extensions.setOnReactiveClickListener

class ArticleItemBinderImp(
    viewModel: MarketplaceViewModel,
    private val onClicked: (Article.Success) -> Unit,
    private val lifecycleOwner: () -> LifecycleOwner,
) : ArticleItemBinder<Article.Success> {

    private lateinit var binding: ArticleItemBinding

    override fun bind(position: Int, binding: ArticleItemBinding, article: Article.Success) {
        this.binding = binding
        binding.articleItemTv.text = article.name
        binding.articleItemTv.setOnReactiveClickListener { onClicked(article) }
        /*when (article) {
            is Article.Success.Mug -> TODO()
            is Article.Success.TShirt -> TODO()
            is Article.Success.Voucher -> TODO()
        }*/
    }

    override fun unBind() {
        TODO("Not yet implemented")
    }

}
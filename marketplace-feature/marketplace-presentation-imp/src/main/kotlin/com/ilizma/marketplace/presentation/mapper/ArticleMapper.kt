package com.ilizma.marketplace.presentation.mapper

import com.ilizma.marketplace.domain.model.Article
import com.ilizma.marketplace.domain.model.Article.*
import com.ilizma.marketplace.presentation.model.Article as PresentationArticle

class ArticleMapper {

    fun from(
        article: Article,
    ): PresentationArticle.Success = when (article) {
        is Mug -> PresentationArticle.Success.Mug(
            name = article.name,
            priceWithSymbol = article.priceWithSymbol,
        )
        is TShirt -> PresentationArticle.Success.TShirt(
            name = article.name,
            priceWithSymbol = article.priceWithSymbol,
            discountDescription = article.discountDescription,
        )
        is Voucher -> PresentationArticle.Success.Voucher(
            name = article.name,
            priceWithSymbol = article.priceWithSymbol,
            discountDescription = article.discountDescription,
        )
    }

}
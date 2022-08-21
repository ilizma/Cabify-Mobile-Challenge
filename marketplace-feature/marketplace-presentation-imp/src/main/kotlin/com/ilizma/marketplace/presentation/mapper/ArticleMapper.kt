package com.ilizma.marketplace.presentation.mapper

import com.ilizma.marketplace.domain.model.Article
import com.ilizma.marketplace.domain.model.Article.*
import com.ilizma.marketplace.presentation.model.Article as PresentationArticle

class ArticleMapper {

    fun from(
        article: Article,
    ): PresentationArticle = when (article) {
        is Mug -> PresentationArticle.Mug(
            name = article.name,
            price = article.price,
        )
        is TShirt -> PresentationArticle.TShirt(
            name = article.name,
            price = article.price,
            discountDescription = article.discountDescription,
        )
        is Voucher -> PresentationArticle.Voucher(
            name = article.name,
            price = article.price,
            discountDescription = article.discountDescription,
        )
    }

}
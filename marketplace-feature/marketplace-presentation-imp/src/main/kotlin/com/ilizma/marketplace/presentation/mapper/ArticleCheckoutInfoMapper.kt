package com.ilizma.marketplace.presentation.mapper

import com.ilizma.marketplace.domain.model.ArticleCheckoutInfo
import com.ilizma.marketplace.presentation.model.ArticleCheckoutInfo as PresentationArticleCheckoutInfo

class ArticleCheckoutInfoMapper {

    fun from(
        articlesCheckoutInfo: ArticleCheckoutInfo,
    ): PresentationArticleCheckoutInfo = when (articlesCheckoutInfo) {
        is ArticleCheckoutInfo.Mug -> PresentationArticleCheckoutInfo.Mug(
            name = articlesCheckoutInfo.name,
            quantity = articlesCheckoutInfo.quantity,
            price = articlesCheckoutInfo.price,
        )
        is ArticleCheckoutInfo.TShirt -> PresentationArticleCheckoutInfo.TShirt(
            name = articlesCheckoutInfo.name,
            quantity = articlesCheckoutInfo.quantity,
            price = articlesCheckoutInfo.price,
            oldPrice = articlesCheckoutInfo.oldPrice,
        )
        is ArticleCheckoutInfo.Voucher -> PresentationArticleCheckoutInfo.Voucher(
            name = articlesCheckoutInfo.name,
            quantity = articlesCheckoutInfo.quantity,
            price = articlesCheckoutInfo.price,
            promotion = articlesCheckoutInfo.promotion
        )
    }

}
package com.ilizma.marketplace.presentation.mapper

import com.ilizma.marketplace.domain.model.ArticleCheckoutInfo
import com.ilizma.marketplace.presentation.model.ArticleCheckoutInfo as PresentationArticleCheckoutInfo

class ArticleCheckoutInfoMapper {

    fun from(
        articleCheckoutInfo: ArticleCheckoutInfo,
    ): PresentationArticleCheckoutInfo = when (articleCheckoutInfo) {
        is ArticleCheckoutInfo.Mug -> PresentationArticleCheckoutInfo.Mug(
            name = articleCheckoutInfo.name,
            quantity = articleCheckoutInfo.quantity,
            priceWithSymbol = articleCheckoutInfo.priceWithSymbol,
            totalPrice = articleCheckoutInfo.totalPrice,
        )
        is ArticleCheckoutInfo.TShirt -> PresentationArticleCheckoutInfo.TShirt(
            name = articleCheckoutInfo.name,
            quantity = articleCheckoutInfo.quantity,
            priceWithSymbol = articleCheckoutInfo.priceWithSymbol,
            totalPrice = articleCheckoutInfo.totalPrice,
            oldPrice = articleCheckoutInfo.oldPrice,
        )
        is ArticleCheckoutInfo.Voucher -> PresentationArticleCheckoutInfo.Voucher(
            name = articleCheckoutInfo.name,
            quantity = articleCheckoutInfo.quantity,
            priceWithSymbol = articleCheckoutInfo.priceWithSymbol,
            totalPrice = articleCheckoutInfo.totalPrice,
            promotion = articleCheckoutInfo.promotion,
        )
    }

}
package com.ilizma.marketplace.flow.mapper

import com.ilizma.checkout.flow.model.ArticleArgs
import com.ilizma.marketplace.presentation.model.ArticleCheckoutInfo

class ArticleArgsMapper {

    fun from(
        articleCheckoutInfo: ArticleCheckoutInfo,
    ): ArticleArgs = when (articleCheckoutInfo) {
        is ArticleCheckoutInfo.Mug -> ArticleArgs.Mug(
            name = articleCheckoutInfo.name,
            quantity = articleCheckoutInfo.quantity,
            price = articleCheckoutInfo.price,
        )
        is ArticleCheckoutInfo.TShirt -> ArticleArgs.TShirt(
            name = articleCheckoutInfo.name,
            quantity = articleCheckoutInfo.quantity,
            price = articleCheckoutInfo.price,
            oldPrice = articleCheckoutInfo.oldPrice,
        )
        is ArticleCheckoutInfo.Voucher -> ArticleArgs.Voucher(
            name = articleCheckoutInfo.name,
            quantity = articleCheckoutInfo.quantity,
            price = articleCheckoutInfo.price,
            promotion = articleCheckoutInfo.promotion,
        )
    }

}
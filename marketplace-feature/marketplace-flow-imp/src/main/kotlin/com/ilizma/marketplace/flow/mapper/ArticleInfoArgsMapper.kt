package com.ilizma.marketplace.flow.mapper

import com.ilizma.checkout.flow.model.ArticleInfoArgs
import com.ilizma.marketplace.presentation.model.ArticleCheckoutInfo

class ArticleInfoArgsMapper {

    fun from(
        articleCheckoutInfo: ArticleCheckoutInfo,
    ): ArticleInfoArgs = when (articleCheckoutInfo) {
        is ArticleCheckoutInfo.Mug -> ArticleInfoArgs.Mug(
            name = articleCheckoutInfo.name,
            quantity = articleCheckoutInfo.quantity,
            priceWithSymbol = articleCheckoutInfo.priceWithSymbol,
            totalPrice = articleCheckoutInfo.totalPrice,
        )
        is ArticleCheckoutInfo.TShirt -> ArticleInfoArgs.TShirt(
            name = articleCheckoutInfo.name,
            quantity = articleCheckoutInfo.quantity,
            priceWithSymbol = articleCheckoutInfo.priceWithSymbol,
            totalPrice = articleCheckoutInfo.totalPrice,
            oldPrice = articleCheckoutInfo.oldPrice,
        )
        is ArticleCheckoutInfo.Voucher -> ArticleInfoArgs.Voucher(
            name = articleCheckoutInfo.name,
            quantity = articleCheckoutInfo.quantity,
            priceWithSymbol = articleCheckoutInfo.priceWithSymbol,
            totalPrice = articleCheckoutInfo.totalPrice,
            promotion = articleCheckoutInfo.promotion,
        )
    }

}
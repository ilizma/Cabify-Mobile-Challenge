package com.ilizma.checkout.flow.mapper

import com.ilizma.checkout.data.model.CheckoutInfo
import com.ilizma.checkout.flow.model.ArticleInfoArgs

class CheckoutInfoMapper {

    fun from(
        args: ArticleInfoArgs,
    ): CheckoutInfo = when (args) {
        is ArticleInfoArgs.Mug -> CheckoutInfo.Mug(
            name = args.name,
            quantity = args.quantity,
            priceWithSymbol = args.priceWithSymbol,
            totalPrice = args.totalPrice,
        )
        is ArticleInfoArgs.TShirt -> CheckoutInfo.TShirt(
            name = args.name,
            quantity = args.quantity,
            oldPrice = args.oldPrice,
            priceWithSymbol = args.priceWithSymbol,
            totalPrice = args.totalPrice,
        )
        is ArticleInfoArgs.Voucher -> CheckoutInfo.Voucher(
            name = args.name,
            quantity = args.quantity,
            promotion = args.promotion,
            priceWithSymbol = args.priceWithSymbol,
            totalPrice = args.totalPrice,
        )
    }

}
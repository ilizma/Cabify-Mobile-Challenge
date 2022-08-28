package com.ilizma.checkout.flow.mapper

import com.ilizma.checkout.data.model.CheckoutInfo
import com.ilizma.checkout.flow.model.ArticleArgs

class CheckoutInfoMapper {

    fun from(
        args: ArticleArgs,
    ): CheckoutInfo = when (args) {
        is ArticleArgs.Mug -> CheckoutInfo.Mug(
            name = args.name,
            quantity = args.quantity,
            price = args.price,
        )
        is ArticleArgs.TShirt -> CheckoutInfo.TShirt(
            name = args.name,
            quantity = args.quantity,
            price = args.price,
            oldPrice = args.oldPrice,
        )
        is ArticleArgs.Voucher -> CheckoutInfo.Voucher(
            name = args.name,
            quantity = args.quantity,
            price = args.price,
            promotion = args.promotion,
        )
    }

}
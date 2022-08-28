package com.ilizma.checkout.data.mapper

import com.ilizma.checkout.domain.model.CheckoutInfo
import com.ilizma.checkout.domain.model.CheckoutInfo.*
import com.ilizma.checkout.data.model.CheckoutInfo as DataCheckoutInfo

class CheckoutInfoMapper {

    fun from(
        checkoutInfo: DataCheckoutInfo,
    ): CheckoutInfo = when (checkoutInfo) {
        is DataCheckoutInfo.Mug -> Mug(
            name = checkoutInfo.name,
            quantity = checkoutInfo.quantity,
            price = checkoutInfo.price,
        )
        is DataCheckoutInfo.TShirt -> TShirt(
            name = checkoutInfo.name,
            quantity = checkoutInfo.quantity,
            price = checkoutInfo.price,
            oldPrice = checkoutInfo.oldPrice,
        )
        is DataCheckoutInfo.Voucher -> Voucher(
            name = checkoutInfo.name,
            quantity = checkoutInfo.quantity,
            price = checkoutInfo.price,
            promotion = checkoutInfo.promotion,
        )
    }

}
package com.ilizma.checkout.presentation.mapper

import com.ilizma.checkout.domain.model.CheckoutInfo
import com.ilizma.checkout.domain.model.CheckoutInfo.*
import com.ilizma.checkout.presentation.model.CheckoutInfo as PresentationCheckoutInfo

class CheckoutInfoMapper {

    fun from(
        checkoutInfo: CheckoutInfo,
    ): PresentationCheckoutInfo = when (checkoutInfo) {
        is Mug -> PresentationCheckoutInfo.Mug(
            name = checkoutInfo.name,
            quantity = checkoutInfo.quantity,
            priceWithSymbol = checkoutInfo.priceWithSymbol,
            totalPriceWithSymbol = checkoutInfo.totalPriceWithSymbol,
        )
        is TShirt -> PresentationCheckoutInfo.TShirt(
            name = checkoutInfo.name,
            quantity = checkoutInfo.quantity,
            priceWithSymbol = checkoutInfo.priceWithSymbol,
            totalPriceWithSymbol = checkoutInfo.totalPriceWithSymbol,
            oldPrice = checkoutInfo.oldPrice,
        )
        is Voucher -> PresentationCheckoutInfo.Voucher(
            name = checkoutInfo.name,
            quantity = checkoutInfo.quantity,
            priceWithSymbol = checkoutInfo.priceWithSymbol,
            totalPriceWithSymbol = checkoutInfo.totalPriceWithSymbol,
            promotion = checkoutInfo.promotion,
        )
    }

}
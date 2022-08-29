package com.ilizma.checkout.data.mapper

import com.ilizma.checkout.domain.model.CheckoutInfo
import com.ilizma.checkout.domain.model.CheckoutInfo.*
import java.util.*
import com.ilizma.checkout.data.model.CheckoutInfo as DataCheckoutInfo

private const val TWO_DECIMAL_FORMAT = "%.2f"

class CheckoutInfoMapper(
    private val locale: Locale,
    private val currencySymbolText: String,
) {

    fun from(
        checkoutInfo: DataCheckoutInfo,
    ): CheckoutInfo = when (checkoutInfo) {
        is DataCheckoutInfo.Mug -> Mug(
            name = checkoutInfo.name,
            quantity = checkoutInfo.quantity,
            priceWithSymbol = checkoutInfo.priceWithSymbol,
            totalPriceWithSymbol = String.format(locale, TWO_DECIMAL_FORMAT, checkoutInfo.totalPrice)
                .let { currencySymbolText.format(it) },
        )
        is DataCheckoutInfo.TShirt -> TShirt(
            name = checkoutInfo.name,
            quantity = checkoutInfo.quantity,
            priceWithSymbol = checkoutInfo.priceWithSymbol,
            totalPriceWithSymbol = String.format(locale, TWO_DECIMAL_FORMAT, checkoutInfo.totalPrice)
                .let { currencySymbolText.format(it) },
            oldPrice = checkoutInfo.oldPrice,
        )
        is DataCheckoutInfo.Voucher -> Voucher(
            name = checkoutInfo.name,
            quantity = checkoutInfo.quantity,
            priceWithSymbol = checkoutInfo.priceWithSymbol,
            totalPriceWithSymbol = String.format(locale, TWO_DECIMAL_FORMAT, checkoutInfo.totalPrice)
                .let { currencySymbolText.format(it) },
            promotion = checkoutInfo.promotion,
        )
    }

}
package com.ilizma.checkout.domain.model

sealed class CheckoutInfo(
    open val name: String,
    open val quantity: Int,
    open val priceWithSymbol: String,
    open val totalPriceWithSymbol: String,
    open val oldPrice: String?,
    open val promotion: String?,
) {

    data class Voucher(
        override val name: String,
        override val quantity: Int,
        override val priceWithSymbol: String,
        override val totalPriceWithSymbol: String,
        override val promotion: String,
    ) : CheckoutInfo(
        name = name,
        quantity = quantity,
        priceWithSymbol = priceWithSymbol,
        totalPriceWithSymbol = totalPriceWithSymbol,
        oldPrice = null,
        promotion = promotion,
    )

    data class TShirt(
        override val name: String,
        override val quantity: Int,
        override val priceWithSymbol: String,
        override val totalPriceWithSymbol: String,
        override val oldPrice: String,
    ) : CheckoutInfo(
        name = name,
        quantity = quantity,
        priceWithSymbol = priceWithSymbol,
        totalPriceWithSymbol = totalPriceWithSymbol,
        oldPrice = oldPrice,
        promotion = null,
    )

    data class Mug(
        override val name: String,
        override val quantity: Int,
        override val priceWithSymbol: String,
        override val totalPriceWithSymbol: String,
    ) : CheckoutInfo(
        name = name,
        quantity = quantity,
        priceWithSymbol = priceWithSymbol,
        totalPriceWithSymbol = totalPriceWithSymbol,
        oldPrice = null,
        promotion = null,
    )

}
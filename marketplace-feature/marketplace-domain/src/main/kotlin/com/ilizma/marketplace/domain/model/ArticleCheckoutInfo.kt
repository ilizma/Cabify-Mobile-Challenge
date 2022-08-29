package com.ilizma.marketplace.domain.model

sealed class ArticleCheckoutInfo(
    open val name: String,
    open val quantity: Int,
    open val priceWithSymbol: String,
    open val totalPrice: Float,
    open val oldPrice: String?,
    open val promotion: String?,
) {

    data class Voucher(
        override val name: String,
        override val quantity: Int,
        override val priceWithSymbol: String,
        override val totalPrice: Float,
        override val promotion: String,
    ) : ArticleCheckoutInfo(
        name = name,
        quantity = quantity,
        priceWithSymbol = priceWithSymbol,
        totalPrice = totalPrice,
        oldPrice = null,
        promotion = promotion,
    )

    data class TShirt(
        override val name: String,
        override val quantity: Int,
        override val priceWithSymbol: String,
        override val totalPrice: Float,
        override val oldPrice: String,
    ) : ArticleCheckoutInfo(
        name = name,
        quantity = quantity,
        priceWithSymbol = priceWithSymbol,
        totalPrice = totalPrice,
        oldPrice = oldPrice,
        promotion = null,
    )

    data class Mug(
        override val name: String,
        override val quantity: Int,
        override val priceWithSymbol: String,
        override val totalPrice: Float,
    ) : ArticleCheckoutInfo(
        name = name,
        quantity = quantity,
        priceWithSymbol = priceWithSymbol,
        totalPrice = totalPrice,
        oldPrice = null,
        promotion = null,
    )

}
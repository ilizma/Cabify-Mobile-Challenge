package com.ilizma.marketplace.domain.model

sealed class ArticleCheckoutInfo(
    open val name: String,
    open val quantity: Int,
    open val price: String,
    open val oldPrice: String?,
    open val promotion: String?,
) {

    data class Voucher(
        override val name: String,
        override val quantity: Int,
        override val price: String,
        override val promotion: String,
    ) : ArticleCheckoutInfo(
        name = name,
        quantity = quantity,
        price = price,
        oldPrice = null,
        promotion = promotion,
    )

    data class TShirt(
        override val name: String,
        override val quantity: Int,
        override val price: String,
        override val oldPrice: String,
    ) : ArticleCheckoutInfo(
        name = name,
        quantity = quantity,
        price = price,
        oldPrice = oldPrice,
        promotion = null,
    )

    data class Mug(
        override val name: String,
        override val quantity: Int,
        override val price: String,
    ) : ArticleCheckoutInfo(
        name = name,
        quantity = quantity,
        price = price,
        oldPrice = null,
        promotion = null,
    )

}
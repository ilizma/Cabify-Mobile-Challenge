package com.ilizma.marketplace.domain.model

sealed class Article(
    open val name: String,
    open val price: String,
) {

    data class Voucher(
        override val name: String,
        override val price: String,
        val discountDescription: String,
    ) : Article(
        name = name,
        price = price,
    )

    data class TShirt(
        override val name: String,
        override val price: String,
        val discountDescription: String,
    ) : Article(
        name = name,
        price = price,
    )

    data class Mug(
        override val name: String,
        override val price: String,
    ) : Article(
        name = name,
        price = price,
    )

}
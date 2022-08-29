package com.ilizma.marketplace.domain.model

sealed class Article(
    open val name: String,
    open val priceWithSymbol: String,
) {

    data class Voucher(
        override val name: String,
        override val priceWithSymbol: String,
        val discountDescription: String,
    ) : Article(
        name = name,
        priceWithSymbol = priceWithSymbol,
    )

    data class TShirt(
        override val name: String,
        override val priceWithSymbol: String,
        val discountDescription: String,
    ) : Article(
        name = name,
        priceWithSymbol = priceWithSymbol,
    )

    data class Mug(
        override val name: String,
        override val priceWithSymbol: String,
    ) : Article(
        name = name,
        priceWithSymbol = priceWithSymbol,
    )

}
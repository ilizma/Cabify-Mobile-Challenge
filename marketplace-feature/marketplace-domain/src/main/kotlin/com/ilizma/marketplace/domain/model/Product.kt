package com.ilizma.marketplace.domain.model

sealed class Product(
    open val name: String,
    open val priceWithSymbol: String,
    open val price: Float,
) {

    data class Voucher(
        override val name: String,
        override val priceWithSymbol: String,
        override val price: Float,
    ) : Product(
        name = name,
        priceWithSymbol = priceWithSymbol,
        price = price,
    )

    data class TShirt(
        override val name: String,
        override val priceWithSymbol: String,
        override val price: Float,
    ) : Product(
        name = name,
        priceWithSymbol = priceWithSymbol,
        price = price,
    )

    data class Mug(
        override val name: String,
        override val priceWithSymbol: String,
        override val price: Float,
    ) : Product(
        name = name,
        priceWithSymbol = priceWithSymbol,
        price = price,
    )

}
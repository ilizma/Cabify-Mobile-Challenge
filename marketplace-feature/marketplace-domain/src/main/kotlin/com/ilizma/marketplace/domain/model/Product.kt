package com.ilizma.marketplace.domain.model

sealed class Product(
    open val name: String,
    open val price: String,
) {

    data class Voucher(
        override val name: String,
        override val price: String,
    ) : Product(
        name = name,
        price = price,
    )

    data class TShirt(
        override val name: String,
        override val price: String,
    ) : Product(
        name = name,
        price = price,
    )

    data class Mug(
        override val name: String,
        override val price: String,
    ) : Product(
        name = name,
        price = price,
    )

}
package com.ilizma.marketplace.domain.model

sealed class Discount(
    open val description: String,
) {

    data class Voucher(
        override val description: String,
    ) : Discount(
        description = description,
    )

    data class TShirt(
        override val description: String,
    ) : Discount(
        description = description,
    )

}
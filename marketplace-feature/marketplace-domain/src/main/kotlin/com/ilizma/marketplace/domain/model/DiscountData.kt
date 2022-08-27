package com.ilizma.marketplace.domain.model

sealed class DiscountData(
    open val quantity: Int,
    open val offer: Int,
) {

    data class Promotion(
        override val quantity: Int,
        override val offer: Int,
    ) : DiscountData(
        quantity = quantity,
        offer = offer,
    )

    data class Bulk(
        override val quantity: Int,
        override val offer: Int,
    ) : DiscountData(
        quantity = quantity,
        offer = offer,
    )

}
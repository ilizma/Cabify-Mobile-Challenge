package com.ilizma.marketplace.domain.model

sealed class DiscountDescription(
    open val description: String,
) {

    data class Promotion(
        override val description: String,
    ) : DiscountDescription(
        description = description,
    )

    data class Bulk(
        override val description: String,
    ) : DiscountDescription(
        description = description,
    )

}
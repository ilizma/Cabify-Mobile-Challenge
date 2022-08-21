package com.ilizma.marketplace.domain.model

sealed class Discount(
    open val description: String,
) {

    data class Promotion(
        override val description: String,
    ) : Discount(
        description = description,
    )

    data class Bulk(
        override val description: String,
    ) : Discount(
        description = description,
    )

}
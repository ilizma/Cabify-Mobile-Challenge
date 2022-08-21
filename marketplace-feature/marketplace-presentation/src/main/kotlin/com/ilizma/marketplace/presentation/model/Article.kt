package com.ilizma.marketplace.presentation.model

sealed class Article {

    sealed class Success(
        open val name: String,
        open val price: String,
    ) : Article() {

        data class Voucher(
            override val name: String,
            override val price: String,
            val discountDescription: String,
        ) : Success(
            name = name,
            price = price,
        )

        data class TShirt(
            override val name: String,
            override val price: String,
            val discountDescription: String,
        ) : Success(
            name = name,
            price = price,
        )

        data class Mug(
            override val name: String,
            override val price: String,
        ) : Success(
            name = name,
            price = price,
        )

    }

    object Loading : Article()

}
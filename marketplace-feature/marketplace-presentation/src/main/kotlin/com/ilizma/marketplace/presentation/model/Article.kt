package com.ilizma.marketplace.presentation.model

sealed class Article {

    sealed class Success(
        open val name: String,
        open val priceWithSymbol: String,
    ) : Article() {

        data class Voucher(
            override val name: String,
            override val priceWithSymbol: String,
            val discountDescription: String,
        ) : Success(
            name = name,
            priceWithSymbol = priceWithSymbol,
        )

        data class TShirt(
            override val name: String,
            override val priceWithSymbol: String,
            val discountDescription: String,
        ) : Success(
            name = name,
            priceWithSymbol = priceWithSymbol,
        )

        data class Mug(
            override val name: String,
            override val priceWithSymbol: String,
        ) : Success(
            name = name,
            priceWithSymbol = priceWithSymbol,
        )

    }

    object Loading : Article()

}
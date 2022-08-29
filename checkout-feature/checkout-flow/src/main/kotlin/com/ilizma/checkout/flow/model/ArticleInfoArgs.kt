package com.ilizma.checkout.flow.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class ArticleInfoArgs(
    open val name: String,
    open val quantity: Int,
    open val priceWithSymbol: String,
    open val totalPrice: Float,
    open val oldPrice: String?,
    open val promotion: String?,
) : Parcelable {

    @Parcelize
    data class Voucher(
        override val name: String,
        override val quantity: Int,
        override val priceWithSymbol: String,
        override val totalPrice: Float,
        override val promotion: String,
    ) : ArticleInfoArgs(
        name = name,
        quantity = quantity,
        priceWithSymbol = priceWithSymbol,
        totalPrice = totalPrice,
        oldPrice = null,
        promotion = promotion,
    )

    @Parcelize
    data class TShirt(
        override val name: String,
        override val quantity: Int,
        override val priceWithSymbol: String,
        override val totalPrice: Float,
        override val oldPrice: String,
    ) : ArticleInfoArgs(
        name = name,
        quantity = quantity,
        priceWithSymbol = priceWithSymbol,
        totalPrice = totalPrice,
        oldPrice = oldPrice,
        promotion = null,
    )

    @Parcelize
    data class Mug(
        override val name: String,
        override val quantity: Int,
        override val priceWithSymbol: String,
        override val totalPrice: Float,
    ) : ArticleInfoArgs(
        name = name,
        quantity = quantity,
        priceWithSymbol = priceWithSymbol,
        totalPrice = totalPrice,
        oldPrice = null,
        promotion = null,
    )

}
package com.ilizma.checkout.flow.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

sealed class ArticleArgs(
    open val name: String,
    open val quantity: Int,
    open val price: String,
    open val oldPrice: String?,
    open val promotion: String?,
) : Parcelable {

    @Parcelize
    data class Voucher(
        override val name: String,
        override val quantity: Int,
        override val price: String,
        override val promotion: String,
    ) : ArticleArgs(
        name = name,
        quantity = quantity,
        price = price,
        oldPrice = null,
        promotion = promotion,
    )

    @Parcelize
    data class TShirt(
        override val name: String,
        override val quantity: Int,
        override val price: String,
        override val oldPrice: String,
    ) : ArticleArgs(
        name = name,
        quantity = quantity,
        price = price,
        oldPrice = oldPrice,
        promotion = null,
    )

    @Parcelize
    data class Mug(
        override val name: String,
        override val quantity: Int,
        override val price: String,
    ) : ArticleArgs(
        name = name,
        quantity = quantity,
        price = price,
        oldPrice = null,
        promotion = null,
    )

}
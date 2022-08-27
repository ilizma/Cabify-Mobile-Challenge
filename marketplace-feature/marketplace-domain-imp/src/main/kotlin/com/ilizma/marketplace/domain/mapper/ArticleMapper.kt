package com.ilizma.marketplace.domain.mapper

import com.ilizma.marketplace.domain.model.Article
import com.ilizma.marketplace.domain.model.DiscountDescription
import com.ilizma.marketplace.domain.model.DiscountDescriptions
import com.ilizma.marketplace.domain.model.Product
import com.ilizma.marketplace.domain.model.Product.*

class ArticleMapper {

    fun from(
        product: Product,
        discountDescriptions: DiscountDescriptions,
    ): Article = when (product) {
        is Mug -> Article.Mug(
            name = product.name,
            price = product.price,
        )
        is TShirt -> Article.TShirt(
            name = product.name,
            price = product.price,
            discountDescription = discountDescriptions.list.first { it is DiscountDescription.Bulk }.description,
        )
        is Voucher -> Article.Voucher(
            name = product.name,
            price = product.price,
            discountDescription = discountDescriptions.list.first { it is DiscountDescription.Promotion }.description,
        )
    }

}
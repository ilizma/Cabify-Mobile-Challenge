package com.ilizma.marketplace.domain.mapper

import com.ilizma.marketplace.domain.model.Article
import com.ilizma.marketplace.domain.model.Discount
import com.ilizma.marketplace.domain.model.Discounts
import com.ilizma.marketplace.domain.model.Product
import com.ilizma.marketplace.domain.model.Product.*

class ArticleMapper {

    fun from(
        product: Product,
        discounts: Discounts,
    ): Article = when (product) {
        is Mug -> Article.Mug(
            name = product.name,
            price = product.price,
        )
        is TShirt -> Article.TShirt(
            name = product.name,
            price = product.price,
            discountDescription = discounts.list.first { it is Discount.TShirt }.description,
        )
        is Voucher -> Article.Voucher(
            name = product.name,
            price = product.price,
            discountDescription = discounts.list.first { it is Discount.Voucher }.description,
        )
    }

}
package com.ilizma.marketplace.data.mapper

import com.ilizma.api.model.ProductCodeDTO
import com.ilizma.api.model.ProductDTO
import com.ilizma.marketplace.domain.model.Article
import com.ilizma.marketplace.domain.model.Product
import com.ilizma.marketplace.domain.model.Product.*
import java.util.*
import com.ilizma.marketplace.data.model.Product as DataProduct

private const val TWO_DECIMAL_FORMAT = "%.2f"

class ProductMapper(
    private val locale: Locale,
    private val moneyText: String,
) {

    fun from(
        nullableDto: ProductDTO?,
    ): DataProduct = nullableDto
        ?.let { dto ->
            when (dto.code) {
                ProductCodeDTO.VOUCHER -> DataProduct.Voucher(
                    name = dto.name ?: "",
                    price = (dto.price ?: 0f)
                        .let { String.format(locale, TWO_DECIMAL_FORMAT, it) }
                        .let { moneyText.format(it) },
                )
                ProductCodeDTO.T_SHIRT -> DataProduct.TShirt(
                    name = dto.name ?: "",
                    price = (dto.price ?: 0f)
                        .let { String.format(locale, TWO_DECIMAL_FORMAT, it) }
                        .let { moneyText.format(it) },
                )
                ProductCodeDTO.MUG -> DataProduct.Mug(
                    name = dto.name ?: "",
                    price = (dto.price ?: 0f)
                        .let { String.format(locale, TWO_DECIMAL_FORMAT, it) }
                        .let { moneyText.format(it) },
                )
                else -> throw IllegalArgumentException("Unknown product code ${dto.code}")
            }
        } ?: throw IllegalArgumentException("Product cannot be null")


    fun from(
        product: DataProduct,
    ): Product = when (product) {
        is DataProduct.Mug -> Mug(
            name = product.name,
            price = product.price,
        )
        is DataProduct.TShirt -> TShirt(
            name = product.name,
            price = product.price,
        )
        is DataProduct.Voucher -> Voucher(
            name = product.name,
            price = product.price,
        )
    }

    fun from(
        product: Product,
    ): DataProduct = when (product) {
        is Mug -> DataProduct.Mug(
            name = product.name,
            price = product.price,
        )
        is TShirt -> DataProduct.TShirt(
            name = product.name,
            price = product.price,
        )
        is Voucher -> DataProduct.Voucher(
            name = product.name,
            price = product.price,
        )
    }

    fun from(
        article: Article,
    ): DataProduct = when (article) {
        is Article.Mug -> DataProduct.Mug(
            name = article.name,
            price = article.price,
        )
        is Article.TShirt -> DataProduct.TShirt(
            name = article.name,
            price = article.price,
        )
        is Article.Voucher -> DataProduct.Voucher(
            name = article.name,
            price = article.price,
        )
    }

}
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
    private val currencySymbolText: String,
) {

    fun from(
        nullableDto: ProductDTO?,
    ): DataProduct = nullableDto
        ?.let { dto ->
            when (dto.code) {
                ProductCodeDTO.VOUCHER -> DataProduct.Voucher(
                    name = dto.name ?: "",
                    priceWithSymbol = (dto.price ?: 0f)
                        .let { String.format(locale, TWO_DECIMAL_FORMAT, it) }
                        .let { currencySymbolText.format(it) },
                    price = (dto.price ?: 0f)
                )
                ProductCodeDTO.T_SHIRT -> DataProduct.TShirt(
                    name = dto.name ?: "",
                    priceWithSymbol = (dto.price ?: 0f)
                        .let { String.format(locale, TWO_DECIMAL_FORMAT, it) }
                        .let { currencySymbolText.format(it) },
                    price = (dto.price ?: 0f)
                )
                ProductCodeDTO.MUG -> DataProduct.Mug(
                    name = dto.name ?: "",
                    priceWithSymbol = (dto.price ?: 0f)
                        .let { String.format(locale, TWO_DECIMAL_FORMAT, it) }
                        .let { currencySymbolText.format(it) },
                    price = (dto.price ?: 0f)
                )
                else -> throw IllegalArgumentException("Unknown product code ${dto.code}")
            }
        } ?: throw IllegalArgumentException("Product cannot be null")


    fun from(
        product: DataProduct,
    ): Product = when (product) {
        is DataProduct.Mug -> Mug(
            name = product.name,
            priceWithSymbol = product.priceWithSymbol,
            price = product.price,
        )
        is DataProduct.TShirt -> TShirt(
            name = product.name,
            priceWithSymbol = product.priceWithSymbol,
            price = product.price,
        )
        is DataProduct.Voucher -> Voucher(
            name = product.name,
            priceWithSymbol = product.priceWithSymbol,
            price = product.price,
        )
    }

}
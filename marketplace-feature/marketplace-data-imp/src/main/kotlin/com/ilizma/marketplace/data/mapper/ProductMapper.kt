package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.domain.model.Product
import com.ilizma.marketplace.domain.model.Product.*
import com.ilizma.marketplace.data.model.Product as DataProduct

class ProductMapper {

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

}
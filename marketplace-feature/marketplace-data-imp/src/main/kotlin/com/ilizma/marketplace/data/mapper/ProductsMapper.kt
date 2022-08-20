package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.domain.model.Products
import com.ilizma.marketplace.data.model.Products as DataProducts

class ProductsMapper(
    private val mapper: ProductMapper,
) {

    fun from(
        products: DataProducts,
    ): Products = products.list.map { mapper.from(it) }
        .let { Products(it) }

}
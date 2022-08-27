package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.domain.model.Product
import com.ilizma.marketplace.data.model.ProductsState as DataProductsState

class ProductsMapper(
    private val mapper: ProductMapper,
) {

    fun from(
        state: DataProductsState.Success,
    ): List<Product> = state.list.map { mapper.from(it) }

}
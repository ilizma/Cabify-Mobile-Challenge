package com.ilizma.marketplace.data.cache

import com.ilizma.marketplace.data.model.ProductsState

class ProductCacheImp(
    private var cache: ProductsState.Success?
) : ProductCache {

    override fun get(
    ): ProductsState.Success? = cache

    override fun set(
        product: ProductsState.Success,
    ) {
        cache = product
    }

}
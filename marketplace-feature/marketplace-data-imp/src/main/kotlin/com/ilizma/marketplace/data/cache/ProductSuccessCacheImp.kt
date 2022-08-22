package com.ilizma.marketplace.data.cache

import com.ilizma.marketplace.data.model.ProductsState

class ProductSuccessCacheImp(
    private var cache: ProductsState.Success?,
) : ProductSuccessCache {

    override fun get(
    ): ProductsState.Success? = cache

    override fun set(
        success: ProductsState.Success,
    ) {
        cache = success
    }

}
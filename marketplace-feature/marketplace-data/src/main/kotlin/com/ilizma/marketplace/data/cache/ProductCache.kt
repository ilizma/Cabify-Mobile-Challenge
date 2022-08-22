package com.ilizma.marketplace.data.cache

import com.ilizma.marketplace.data.model.ProductsState

interface ProductCache {

    fun get(): ProductsState.Success?

    fun set(product: ProductsState.Success)

}
package com.ilizma.marketplace.data.cache

import com.ilizma.marketplace.data.model.ProductsState

interface ProductSuccessCache {

    fun get(): ProductsState.Success?

    fun set(success: ProductsState.Success)

}
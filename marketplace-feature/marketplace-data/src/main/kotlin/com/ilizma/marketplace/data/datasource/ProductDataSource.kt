package com.ilizma.marketplace.data.datasource

import com.ilizma.marketplace.data.model.ProductsState
import io.reactivex.rxjava3.core.Single

interface ProductDataSource {

    fun getProductsState(): Single<ProductsState>

}
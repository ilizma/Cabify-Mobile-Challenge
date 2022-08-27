package com.ilizma.marketplace.domain.repository

import com.ilizma.marketplace.domain.model.Product
import com.ilizma.marketplace.domain.model.ProductsState
import io.reactivex.rxjava3.core.Single

interface ProductRepository {

    fun getProductsState(): Single<ProductsState>

    fun getProductsFromLocal(): Single<List<Product>>

}
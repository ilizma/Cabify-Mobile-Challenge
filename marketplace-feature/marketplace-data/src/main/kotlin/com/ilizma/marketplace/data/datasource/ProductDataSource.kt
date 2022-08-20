package com.ilizma.marketplace.data.datasource

import com.ilizma.marketplace.data.model.Products
import io.reactivex.rxjava3.core.Single

interface ProductDataSource {

    fun getProducts(): Single<Products>

}
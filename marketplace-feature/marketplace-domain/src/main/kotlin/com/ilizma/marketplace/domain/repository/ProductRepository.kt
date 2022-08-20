package com.ilizma.marketplace.domain.repository

import com.ilizma.marketplace.domain.model.Products
import io.reactivex.rxjava3.core.Single

interface ProductRepository {

    fun getProducts(): Single<Products>

}
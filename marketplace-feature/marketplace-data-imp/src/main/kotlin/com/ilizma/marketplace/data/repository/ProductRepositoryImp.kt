package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.datasource.ProductDataSource
import com.ilizma.marketplace.data.mapper.ProductsMapper
import com.ilizma.marketplace.domain.model.Products
import com.ilizma.marketplace.domain.repository.ProductRepository
import io.reactivex.rxjava3.core.Single

class ProductRepositoryImp(
    private val dataSource: ProductDataSource,
    private val mapper: ProductsMapper,
) : ProductRepository {

    override fun getProducts(
    ): Single<Products> = dataSource.getProducts()
        .map { mapper.from(it) }

}
package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.datasource.ProductDataSource
import com.ilizma.marketplace.data.mapper.ProductsStateMapper
import com.ilizma.marketplace.domain.model.ProductsState
import com.ilizma.marketplace.domain.repository.ProductRepository
import io.reactivex.rxjava3.core.Single

class ProductRepositoryImp(
    private val dataSource: ProductDataSource,
    private val mapper: ProductsStateMapper,
) : ProductRepository {

    override fun getProductsState(
    ): Single<ProductsState> = dataSource.getProductsState()
        .map { mapper.from(it) }

}
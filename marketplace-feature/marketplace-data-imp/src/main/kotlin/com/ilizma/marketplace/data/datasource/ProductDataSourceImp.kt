package com.ilizma.marketplace.data.datasource

import com.ilizma.api.data.Api
import com.ilizma.marketplace.data.mapper.ProductsStateMapper
import com.ilizma.marketplace.data.model.ProductsState
import io.reactivex.rxjava3.core.Single

class ProductDataSourceImp(
    private val api: Api,
    private val mapper: ProductsStateMapper,
) : ProductDataSource {

    override fun getProductsState(
    ): Single<ProductsState> = api.getProducts()
        .map { mapper.from(it) }

}

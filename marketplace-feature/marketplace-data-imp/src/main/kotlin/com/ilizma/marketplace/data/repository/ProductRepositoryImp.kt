package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.cache.ProductCache
import com.ilizma.marketplace.data.datasource.ProductDataSource
import com.ilizma.marketplace.data.mapper.ProductsStateMapper
import com.ilizma.marketplace.domain.model.ProductsState
import com.ilizma.marketplace.domain.repository.ProductRepository
import io.reactivex.rxjava3.core.Single
import com.ilizma.marketplace.data.model.ProductsState as DataProductsState

class ProductRepositoryImp(
    private val dataSource: ProductDataSource,
    private val cache: ProductCache,
    private val mapper: ProductsStateMapper,
) : ProductRepository {

    override fun getProductsState(
    ): Single<ProductsState> = getFromCacheIfExist()
        ?: getFromRemote()

    private fun getFromCacheIfExist(
    ): Single<ProductsState>? = cache.get()
        ?.let { it as ProductsState }
        ?.let { Single.just(it) }

    private fun getFromRemote(
    ): Single<ProductsState> = dataSource.getProductsState()
        .map {
            saveCacheIfSuccess(it)
            mapper.from(it)
        }

    private fun saveCacheIfSuccess(
        state: DataProductsState,
    ) {
        if (state is DataProductsState.Success) cache.set(state)
    }

}
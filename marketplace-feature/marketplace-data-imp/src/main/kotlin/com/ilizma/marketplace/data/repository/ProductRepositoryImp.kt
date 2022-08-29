package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.cache.ProductSuccessCache
import com.ilizma.marketplace.data.datasource.ProductDataSource
import com.ilizma.marketplace.data.mapper.ProductsMapper
import com.ilizma.marketplace.data.mapper.ProductsStateMapper
import com.ilizma.marketplace.domain.model.Product
import com.ilizma.marketplace.domain.model.ProductsState
import com.ilizma.marketplace.domain.repository.ProductRepository
import io.reactivex.rxjava3.core.Single
import com.ilizma.marketplace.data.model.ProductsState as DataProductsState

class ProductRepositoryImp(
    private val dataSource: ProductDataSource,
    private val cache: ProductSuccessCache,
    private val productsStateMapper: ProductsStateMapper,
    private val productsMapper: ProductsMapper,
) : ProductRepository {

    override fun getProductsState(
    ): Single<ProductsState> = getFromCacheIfExist()
        ?: getFromRemote()

    override fun getProductsFromLocal(
    ): Single<List<Product>> = cache.get()!!
        .let { productsMapper.from(it) }
        .let { Single.just(it) }

    private fun getFromCacheIfExist(
    ): Single<ProductsState>? = cache.get()
        ?.let { productsStateMapper.from(it) }
        ?.let { Single.just(it) }

    private fun getFromRemote(
    ): Single<ProductsState> = dataSource.getProductsState()
        .map {
            saveCacheIfSuccess(it)
            productsStateMapper.from(it)
        }

    private fun saveCacheIfSuccess(
        state: DataProductsState,
    ) {
        if (state is DataProductsState.Success) cache.set(state)
    }

}
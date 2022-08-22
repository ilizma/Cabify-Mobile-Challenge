package com.ilizma.marketplace.data.cache

import com.ilizma.marketplace.data.model.Product
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class ProductCacheImp(
    private var cacheMap: HashMap<Product, Int>,
) : ProductCache {

    override fun get(
        product: Product,
    ): Single<Int> = (cacheMap[product] ?: 0)
        .let { Single.just(it) }

    override fun add(
        product: Product,
    ): Completable = (cacheMap[product]
        ?.plus(1)
        ?: 1)
        .let { cacheMap[product] = it }
        .let { Completable.complete() }

    override fun remove(
        product: Product,
    ): Completable = (cacheMap[product]
        ?.minus(1)
        ?.let { if (it < 0) 0 else it }
        ?: 0)
        .let { cacheMap[product] = it }
        .let { Completable.complete() }

}
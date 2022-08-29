package com.ilizma.marketplace.data.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class ProductQuantityCacheImp(
    private var cacheMap: HashMap<String, Int>,
) : ProductQuantityCache {

    override fun get(
        productName: String,
    ): Single<Int> = (cacheMap[productName] ?: 0)
        .let { Single.just(it) }

    override fun add(
        productName: String,
    ): Completable = (cacheMap[productName]
        ?.plus(1)
        ?: 1)
        .let { cacheMap[productName] = it }
        .let { Completable.complete() }

    override fun remove(
        productName: String,
    ): Completable = (cacheMap[productName]
        ?.minus(1)
        ?.let { if (it < 0) 0 else it }
        ?: 0)
        .let { cacheMap[productName] = it }
        .let { Completable.complete() }

}
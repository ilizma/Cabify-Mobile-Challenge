package com.ilizma.marketplace.data.cache

import com.ilizma.marketplace.data.model.Product
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface ProductCache {

    fun get(product: Product): Single<Int>

    fun add(product: Product): Completable

    fun remove(product: Product): Completable

}
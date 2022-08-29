package com.ilizma.marketplace.data.cache

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface ProductQuantityCache {

    fun get(productName: String): Single<Int>

    fun add(productName: String): Completable

    fun remove(productName: String): Completable

}
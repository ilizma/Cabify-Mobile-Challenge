package com.ilizma.marketplace.domain.repository

import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface ArticleRepository {

    fun getQuantity(articleName: String): Single<Int>

    fun addQuantity(articleName: String): Completable

    fun removeQuantity(articleName: String): Completable

}
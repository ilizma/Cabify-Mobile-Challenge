package com.ilizma.marketplace.domain.repository

import com.ilizma.marketplace.domain.model.Article
import com.ilizma.marketplace.domain.model.Product
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface ArticleRepository {

    fun getQuantity(article: Article): Single<Int>

    fun getQuantity(product: Product): Single<Int>

    fun addQuantity(article: Article): Completable

    fun removeQuantity(article: Article): Completable

}
package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.cache.ProductQuantityCache
import com.ilizma.marketplace.domain.repository.ArticleRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class ArticleRepositoryImp(
    private val cache: ProductQuantityCache,
) : ArticleRepository {

    override fun getQuantity(
        articleName: String,
    ): Single<Int> = cache.get(articleName)

    override fun addQuantity(
        articleName: String,
    ): Completable = cache.add(articleName)

    override fun removeQuantity(
        articleName: String,
    ): Completable = cache.remove(articleName)

}
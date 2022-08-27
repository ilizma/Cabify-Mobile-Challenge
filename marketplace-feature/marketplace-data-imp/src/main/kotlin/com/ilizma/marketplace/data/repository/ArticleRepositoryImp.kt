package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.cache.ProductCache
import com.ilizma.marketplace.data.mapper.ProductMapper
import com.ilizma.marketplace.domain.model.Article
import com.ilizma.marketplace.domain.model.Product
import com.ilizma.marketplace.domain.repository.ArticleRepository
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

class ArticleRepositoryImp(
    private val cache: ProductCache,
    private val mapper: ProductMapper,
) : ArticleRepository {

    override fun getQuantity(
        article: Article,
    ): Single<Int> = mapper.from(article)
        .let { cache.get(it) }

    override fun getQuantity(
        product: Product,
    ): Single<Int> = mapper.from(product)
        .let { cache.get(it) }

    override fun addQuantity(
        article: Article,
    ): Completable = mapper.from(article)
        .let { cache.add(it) }

    override fun removeQuantity(
        article: Article,
    ): Completable = mapper.from(article)
        .let { cache.remove(it) }

}
package com.ilizma.marketplace.domain.mapper

import com.ilizma.marketplace.domain.model.Articles
import com.ilizma.marketplace.domain.model.Discounts
import com.ilizma.marketplace.domain.model.Products

class ArticlesMapper(
    private val mapper: ArticleMapper,
) {

    fun from(
        products: Products,
        discounts: Discounts,
    ): Articles = products.list.map { mapper.from(it, discounts) }
        .let { Articles(it) }

}
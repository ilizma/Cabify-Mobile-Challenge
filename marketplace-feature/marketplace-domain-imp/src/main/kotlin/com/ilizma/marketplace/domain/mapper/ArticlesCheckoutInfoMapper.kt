package com.ilizma.marketplace.domain.mapper

import com.ilizma.marketplace.domain.model.ArticlesCheckoutInfo
import com.ilizma.marketplace.domain.model.DiscountDataList
import com.ilizma.marketplace.domain.model.Product

class ArticlesCheckoutInfoMapper(
    private val mapper: ArticleCheckoutInfoMapper,
) {

    fun from(
        products: List<Product>,
        productQuantityList: List<Pair<Product, Int>>,
        discounts: DiscountDataList,
    ): ArticlesCheckoutInfo = products
        .map { mapper.from(it, productQuantityList, discounts) }
        .let { ArticlesCheckoutInfo(it) }

}
package com.ilizma.marketplace.presentation.mapper

import com.ilizma.marketplace.domain.model.ArticlesCheckoutInfo
import com.ilizma.marketplace.presentation.model.ArticlesCheckoutInfo as PresentationArticlesCheckoutInfo

class ArticlesCheckoutInfoMapper(
    private val mapper: ArticleCheckoutInfoMapper,
) {

    fun from(
        articlesCheckoutInfo: ArticlesCheckoutInfo,
    ): PresentationArticlesCheckoutInfo = articlesCheckoutInfo.list
        .map { mapper.from(it) }
        .let { PresentationArticlesCheckoutInfo(it) }

}
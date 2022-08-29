package com.ilizma.marketplace.flow.mapper

import com.ilizma.checkout.flow.model.ArticlesInfoArgs
import com.ilizma.marketplace.presentation.model.ArticlesCheckoutInfo

class ArticlesInfoArgsMapper(
    private val mapper: ArticleInfoArgsMapper,
) {

    fun from(
        args: ArticlesCheckoutInfo,
    ): ArticlesInfoArgs = args.list
        .map { mapper.from(it) }
        .let { ArticlesInfoArgs(it) }

}
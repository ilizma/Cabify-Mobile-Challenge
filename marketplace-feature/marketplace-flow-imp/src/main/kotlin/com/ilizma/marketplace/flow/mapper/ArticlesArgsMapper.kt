package com.ilizma.marketplace.flow.mapper

import com.ilizma.checkout.flow.model.ArticlesArgs
import com.ilizma.marketplace.presentation.model.ArticlesCheckoutInfo

class ArticlesArgsMapper(
    private val mapper: ArticleArgsMapper,
) {

    fun from(
        args: ArticlesCheckoutInfo,
    ): ArticlesArgs = args.list
        .map { mapper.from(it) }
        .let { ArticlesArgs(it) }

}
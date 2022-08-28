package com.ilizma.marketplace.domain.mapper

import com.ilizma.marketplace.domain.model.ArticlesState
import com.ilizma.marketplace.domain.model.DiscountDescriptions
import com.ilizma.marketplace.domain.model.ProductsState

class ArticlesStateMapper(
    private val mapper: ArticleMapper,
) {

    fun from(
        state: ProductsState,
        discountDescriptions: DiscountDescriptions,
    ): ArticlesState = when (state) {
        is ProductsState.RemoteError -> ArticlesState.RemoteError(state.message)
        is ProductsState.Success -> state.list
            .map { mapper.from(it, discountDescriptions) }
            .let { ArticlesState.Success(it) }
    }


}
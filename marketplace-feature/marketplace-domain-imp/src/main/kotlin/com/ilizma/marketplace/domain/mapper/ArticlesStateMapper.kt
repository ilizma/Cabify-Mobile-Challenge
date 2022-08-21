package com.ilizma.marketplace.domain.mapper

import com.ilizma.marketplace.domain.model.ArticlesState
import com.ilizma.marketplace.domain.model.Discounts
import com.ilizma.marketplace.domain.model.ProductsState

class ArticlesStateMapper(
    private val mapper: ArticleMapper,
) {

    fun from(
        state: ProductsState,
        discounts: Discounts,
    ): ArticlesState = when (state) {
        is ProductsState.RemoteError -> ArticlesState.RemoteError(state.message)
        is ProductsState.Success -> state.list.map { mapper.from(it, discounts) }
            .let { ArticlesState.Success(it) }
    }


}
package com.ilizma.marketplace.presentation.mapper

import com.ilizma.marketplace.domain.model.ArticlesState
import com.ilizma.marketplace.presentation.model.ArticlesState as PresentationArticlesState

class ArticlesStateMapper(
    private val mapper: ArticleMapper,
) {

    fun from(
        state: ArticlesState.Success,
    ): PresentationArticlesState.Success = state.list.map { mapper.from(it) }
        .let { PresentationArticlesState.Success(it) }


}
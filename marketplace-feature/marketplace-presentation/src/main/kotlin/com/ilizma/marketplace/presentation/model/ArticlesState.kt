package com.ilizma.marketplace.presentation.model

sealed class ArticlesState(
    open val list: List<Article>,
) {

    data class Loading(
        override val list: List<Article.Loading>,
    ) : ArticlesState(
        list = list,
    )

    data class Success(
        override val list: List<Article.Success>,
    ) : ArticlesState(
        list = list,
    )

}
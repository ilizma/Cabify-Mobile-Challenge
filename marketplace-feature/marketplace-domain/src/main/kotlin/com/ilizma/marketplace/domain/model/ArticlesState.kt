package com.ilizma.marketplace.domain.model

sealed class ArticlesState {

    data class Success(
        val list: List<Article>,
    ) : ArticlesState()

    data class RemoteError(
        val message: String,
    ) : ArticlesState()

}
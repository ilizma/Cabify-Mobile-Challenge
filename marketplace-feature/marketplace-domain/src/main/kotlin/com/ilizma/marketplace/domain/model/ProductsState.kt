package com.ilizma.marketplace.domain.model

sealed class ProductsState {

    data class Success(
        val list: List<Product>,
    ) : ProductsState()

    data class RemoteError(
        val message: String,
    ) : ProductsState()

}
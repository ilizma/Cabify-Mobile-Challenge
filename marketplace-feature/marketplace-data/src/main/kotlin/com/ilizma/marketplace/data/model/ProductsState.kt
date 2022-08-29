package com.ilizma.marketplace.data.model

sealed class ProductsState {

    data class Success(
        val list: List<Product>,
    ) : ProductsState()

    data class RemoteError(
        val message: String,
    ) : ProductsState()

}
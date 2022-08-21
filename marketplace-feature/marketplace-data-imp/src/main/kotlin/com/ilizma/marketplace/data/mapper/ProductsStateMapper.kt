package com.ilizma.marketplace.data.mapper

import com.ilizma.api.model.ProductsDTO
import com.ilizma.marketplace.domain.model.ProductsState
import retrofit2.adapter.rxjava3.Result
import com.ilizma.marketplace.data.model.ProductsState as DataProductsState

class ProductsStateMapper(
    private val mapper: ProductMapper,
    private val unknownErrorMessage: String,
) {

    fun from(
        result: Result<ProductsDTO>,
    ): DataProductsState = when {
        result.isError -> DataProductsState.RemoteError(result.error()?.message ?: "")
        else -> result.response()
            ?.body()
            ?.products
            ?.map { mapper.from(it) }
            ?.let { DataProductsState.Success(it) }
            ?: DataProductsState.RemoteError(unknownErrorMessage)
    }

    fun from(
        state: DataProductsState,
    ): ProductsState = when (state) {
        is DataProductsState.RemoteError -> ProductsState.RemoteError(state.message)
        is DataProductsState.Success -> state.list.map { mapper.from(it) }
            .let { ProductsState.Success(it) }
    }

}
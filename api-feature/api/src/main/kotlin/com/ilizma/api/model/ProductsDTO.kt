package com.ilizma.api.model

import com.squareup.moshi.Json

data class ProductsDTO(
    @Json(name = "products") val products: List<ProductDTO>? = null,
)
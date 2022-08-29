package com.ilizma.api.model

import com.squareup.moshi.Json

data class ProductDTO(
    @Json(name = "code") val code: ProductCodeDTO? = null,
    @Json(name = "name") val name: String? = null,
    @Json(name = "price") val price: Float? = null,
)
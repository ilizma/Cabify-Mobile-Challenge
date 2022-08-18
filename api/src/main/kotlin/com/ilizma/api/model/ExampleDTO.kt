package com.ilizma.api.model

import com.squareup.moshi.Json

data class ExampleDTO(
    @Json(name = "example") val example: String? = null,
)
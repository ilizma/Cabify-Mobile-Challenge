package com.ilizma.api.model

import com.squareup.moshi.Json

enum class ProductCodeDTO{
    @Json(name = "VOUCHER") VOUCHER,
    @Json(name = "TSHIRT") T_SHIRT,
    @Json(name = "MUG") MUG,
}
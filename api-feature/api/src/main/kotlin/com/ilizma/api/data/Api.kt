package com.ilizma.api.data

import com.ilizma.api.model.ProductsDTO
import io.reactivex.rxjava3.core.Single
import retrofit2.adapter.rxjava3.Result
import retrofit2.http.GET

interface Api {

    @GET("palcalde/6c19259bd32dd6aafa327fa557859c2f/raw/ba51779474a150ee4367cda4f4ffacdcca479887/Products.json")
    fun getProducts(): Single<Result<ProductsDTO>>

}
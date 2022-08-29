package com.ilizma.checkout.data.datasource

import com.ilizma.checkout.data.model.CheckoutInfoList
import io.reactivex.rxjava3.core.Single

interface CheckoutDataSource {

    fun getCheckoutInfoList(): Single<CheckoutInfoList>

}
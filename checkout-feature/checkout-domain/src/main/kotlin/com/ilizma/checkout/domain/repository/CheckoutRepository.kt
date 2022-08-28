package com.ilizma.checkout.domain.repository

import com.ilizma.checkout.domain.model.CheckoutInfoList
import io.reactivex.rxjava3.core.Single

interface CheckoutRepository {

    fun getCheckoutInfoList(): Single<CheckoutInfoList>

}
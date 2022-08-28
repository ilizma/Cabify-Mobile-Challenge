package com.ilizma.checkout.data.datasource

import com.ilizma.checkout.data.model.CheckoutInfoList
import io.reactivex.rxjava3.core.Single

class CheckoutDataSourceImp(
    private val checkoutInfoList: () -> CheckoutInfoList,
) : CheckoutDataSource {

    override fun getCheckoutInfoList(
    ): Single<CheckoutInfoList> = Single.just(checkoutInfoList())

}

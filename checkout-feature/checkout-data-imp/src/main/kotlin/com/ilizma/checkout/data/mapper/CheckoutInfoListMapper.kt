package com.ilizma.checkout.data.mapper

import com.ilizma.checkout.domain.model.CheckoutInfoList
import com.ilizma.checkout.data.model.CheckoutInfoList as DataCheckoutInfoList

class CheckoutInfoListMapper(
    private val mapper: CheckoutInfoMapper,
) {

    fun from(
        checkoutInfoList: DataCheckoutInfoList,
    ): CheckoutInfoList = checkoutInfoList.list
        .map { mapper.from(it) }
        .let { CheckoutInfoList(it) }

}
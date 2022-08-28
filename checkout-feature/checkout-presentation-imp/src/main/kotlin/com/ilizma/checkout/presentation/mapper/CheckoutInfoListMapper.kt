package com.ilizma.checkout.presentation.mapper

import com.ilizma.checkout.domain.model.CheckoutInfoList
import com.ilizma.checkout.presentation.model.CheckoutInfoList as PresentationCheckoutInfoList

class CheckoutInfoListMapper(
    private val mapper: CheckoutInfoMapper,
) {

    fun from(
        checkoutInfoList: CheckoutInfoList,
    ): PresentationCheckoutInfoList = checkoutInfoList.list
        .map { mapper.from(it) }
        .let { PresentationCheckoutInfoList(it) }

}
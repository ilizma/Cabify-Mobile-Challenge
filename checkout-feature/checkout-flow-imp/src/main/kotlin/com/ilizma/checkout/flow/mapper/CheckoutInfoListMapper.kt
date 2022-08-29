package com.ilizma.checkout.flow.mapper

import com.ilizma.checkout.data.model.CheckoutInfoList
import com.ilizma.checkout.flow.model.ArticlesInfoArgs

class CheckoutInfoListMapper(
    private val mapper: CheckoutInfoMapper,
) {

    fun from(
        args: ArticlesInfoArgs,
    ): CheckoutInfoList = args.list
        .map { mapper.from(it) }
        .let { CheckoutInfoList(it) }
}
package com.ilizma.checkout.flow.mapper

import com.ilizma.checkout.data.model.CheckoutInfoList
import com.ilizma.checkout.flow.model.ArticlesArgs

class CheckoutInfoListMapper(
    private val mapper: CheckoutInfoMapper,
) {

    fun from(
        args: ArticlesArgs,
    ): CheckoutInfoList = args.list
        .map { mapper.from(it) }
        .let { CheckoutInfoList(it) }
}
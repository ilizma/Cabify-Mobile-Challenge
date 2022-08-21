package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.data.model.DiscountDataList
import com.ilizma.marketplace.domain.model.Discounts
import com.ilizma.marketplace.data.model.DiscountDescriptions

class DiscountsMapper(
    private val mapper: DiscountDescriptionMapper,
) {

    fun from(
        descriptions: DiscountDescriptions,
        dataList: DiscountDataList,
    ): Discounts = descriptions.list.map { mapper.from(it, dataList) }
        .let { Discounts(it) }

}
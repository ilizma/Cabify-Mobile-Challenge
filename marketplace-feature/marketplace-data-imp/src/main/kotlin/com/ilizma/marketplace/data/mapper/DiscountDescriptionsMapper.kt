package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.data.model.DiscountDataList
import com.ilizma.marketplace.domain.model.DiscountDescriptions
import com.ilizma.marketplace.data.model.DiscountDescriptions as DataDiscountDescriptions

class DiscountDescriptionsMapper(
    private val mapper: DiscountDescriptionMapper,
) {

    fun from(
        descriptions: DataDiscountDescriptions,
        dataList: DiscountDataList,
    ): DiscountDescriptions = descriptions.list
        .map { mapper.from(it, dataList) }
        .let { DiscountDescriptions(it) }

}
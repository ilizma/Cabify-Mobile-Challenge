package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.data.model.DiscountData
import com.ilizma.marketplace.data.model.DiscountDataList
import com.ilizma.marketplace.data.model.DiscountDescription

class DiscountDataQuantityMapper {

    fun from(
        description: DiscountDescription,
        dataList: DiscountDataList,
    ): Int = when (description) {
        is DiscountDescription.Bulk -> dataList.list.first { it is DiscountData.Bulk }.quantity
        is DiscountDescription.Promotion -> dataList.list.first { it is DiscountData.Promotion }.quantity
    }

}
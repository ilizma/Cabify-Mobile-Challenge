package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.domain.model.DiscountDataList
import com.ilizma.marketplace.data.model.DiscountDataList as DataDiscountDataList

class DiscountDataListMapper(
    private val mapper: DiscountDataMapper,
) {

    fun from(
        dataList: DataDiscountDataList,
    ): DiscountDataList = dataList.list.map { mapper.from(it) }
        .let { DiscountDataList(it) }

}
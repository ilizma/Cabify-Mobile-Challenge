package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.domain.model.DiscountData
import com.ilizma.marketplace.domain.model.DiscountData.Bulk
import com.ilizma.marketplace.domain.model.DiscountData.Promotion
import com.ilizma.marketplace.data.model.DiscountData as DataDiscountData

class DiscountDataMapper {

    fun from(
        data: DataDiscountData,
    ): DiscountData = when (data) {
        is DataDiscountData.Bulk -> Bulk(
            quantity = data.quantity,
            offer = data.offer,
        )
        is DataDiscountData.Promotion -> Promotion(
            quantity = data.quantity,
            offer = data.offer,
        )
    }

}
package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.data.model.DiscountDataList
import com.ilizma.marketplace.domain.model.DiscountDescription
import com.ilizma.marketplace.domain.model.DiscountDescription.Bulk
import com.ilizma.marketplace.domain.model.DiscountDescription.Promotion
import com.ilizma.marketplace.data.model.DiscountDescription as DataDiscountDescription

class DiscountDescriptionMapper(
    private val quantityMapper: DiscountDataQuantityMapper,
    private val offerMapper: DiscountDataOfferMapper,
) {

    fun from(
        description: DataDiscountDescription,
        dataList: DiscountDataList,
    ): DiscountDescription = when (description) {
        is DataDiscountDescription.Bulk -> Bulk(
            description = description.description.format(
                quantityMapper.from(description, dataList),
                offerMapper.from(description, dataList)
            ),
        )
        is DataDiscountDescription.Promotion -> Promotion(
            description = description.description.format(
                quantityMapper.from(description, dataList),
                offerMapper.from(description, dataList)
            ),
        )
    }

}
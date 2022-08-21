package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.data.model.DiscountDataList
import com.ilizma.marketplace.data.model.DiscountDescription
import com.ilizma.marketplace.domain.model.Discount
import com.ilizma.marketplace.domain.model.Discount.Bulk
import com.ilizma.marketplace.domain.model.Discount.Promotion

class DiscountDescriptionMapper(
    private val quantityMapper: DiscountDataQuantityMapper,
    private val offerMapper: DiscountDataOfferMapper,
) {

    fun from(
        description: DiscountDescription,
        dataList: DiscountDataList,
    ): Discount = when (description) {
        is DiscountDescription.Bulk -> Bulk(
            description = description.description.format(
                quantityMapper.from(description, dataList),
                offerMapper.from(description, dataList)
            ),
        )
        is DiscountDescription.Promotion -> Promotion(
            description = description.description.format(
                quantityMapper.from(description, dataList),
                offerMapper.from(description, dataList)
            ),
        )
    }

}
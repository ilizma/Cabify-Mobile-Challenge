package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.domain.model.Discounts
import com.ilizma.marketplace.data.model.Discounts as DataDiscounts

class DiscountsMapper(
    private val mapper: DiscountMapper,
) {

    fun from(
        products: DataDiscounts,
    ): Discounts = products.list.map { mapper.from(it) }
        .let { Discounts(it) }

}
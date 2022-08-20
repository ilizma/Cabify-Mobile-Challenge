package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.domain.model.Discount
import com.ilizma.marketplace.domain.model.Discount.*
import com.ilizma.marketplace.data.model.Discount as DataDiscount

class DiscountMapper {

    fun from(
        product: DataDiscount,
    ): Discount = when (product) {
        is DataDiscount.TShirt -> TShirt(
            description = product.description,
        )
        is DataDiscount.Voucher -> Voucher(
            description = product.description,
        )
    }

}
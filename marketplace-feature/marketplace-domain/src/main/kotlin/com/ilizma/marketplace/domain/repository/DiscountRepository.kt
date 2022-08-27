package com.ilizma.marketplace.domain.repository

import com.ilizma.marketplace.domain.model.DiscountDataList
import com.ilizma.marketplace.domain.model.DiscountDescriptions
import io.reactivex.rxjava3.core.Single

interface DiscountRepository {

    fun getDiscountsDescriptions(): Single<DiscountDescriptions>

    fun getDiscounts(): Single<DiscountDataList>

}
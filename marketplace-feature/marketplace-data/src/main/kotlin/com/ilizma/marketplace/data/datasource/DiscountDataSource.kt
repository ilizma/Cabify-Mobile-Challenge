package com.ilizma.marketplace.data.datasource

import com.ilizma.marketplace.data.model.Discounts
import io.reactivex.rxjava3.core.Single

interface DiscountDataSource {

    fun getDiscounts(): Single<Discounts>

}
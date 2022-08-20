package com.ilizma.marketplace.domain.repository

import com.ilizma.marketplace.domain.model.Discounts
import io.reactivex.rxjava3.core.Single

interface DiscountRepository {

    fun getDiscounts(): Single<Discounts>

}
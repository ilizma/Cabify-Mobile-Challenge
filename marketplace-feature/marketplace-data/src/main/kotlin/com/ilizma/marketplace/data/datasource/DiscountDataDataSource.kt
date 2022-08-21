package com.ilizma.marketplace.data.datasource

import com.ilizma.marketplace.data.model.DiscountDataList
import com.ilizma.marketplace.data.model.DiscountDescriptions
import io.reactivex.rxjava3.core.Single

interface DiscountDataDataSource {

    fun getDiscountDataList(): Single<DiscountDataList>

}
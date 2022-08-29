package com.ilizma.marketplace.data.datasource

import com.ilizma.marketplace.data.model.DiscountData
import com.ilizma.marketplace.data.model.DiscountDataList
import io.reactivex.rxjava3.core.Single

private const val PROMOTION_QUANTITY = 2
private const val PROMOTION_OFFER = 1
private const val BULK_QUANTITY = 3
private const val BULK_OFFER = 19

class DiscountDataDataSourceImp : DiscountDataDataSource {

    override fun getDiscountDataList(
    ): Single<DiscountDataList> = listOf(
        DiscountData.Promotion(PROMOTION_QUANTITY, PROMOTION_OFFER),
        DiscountData.Bulk(BULK_QUANTITY, BULK_OFFER),
    ).let { DiscountDataList(it) }
        .let { Single.just(it) }

}

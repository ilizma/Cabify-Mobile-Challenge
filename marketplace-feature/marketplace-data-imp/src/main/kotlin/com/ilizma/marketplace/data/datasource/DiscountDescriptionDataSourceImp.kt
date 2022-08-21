package com.ilizma.marketplace.data.datasource

import com.ilizma.marketplace.data.model.DiscountDescription
import com.ilizma.marketplace.data.model.DiscountDescriptions
import io.reactivex.rxjava3.core.Single

class DiscountDescriptionDataSourceImp(
    private val promotionText: String,
    private val bulkText: String,
) : DiscountDescriptionDataSource {

    override fun getDiscountDescriptions(
    ): Single<DiscountDescriptions> = listOf(
        DiscountDescription.Promotion(promotionText),
        DiscountDescription.Bulk(bulkText),
    ).let { DiscountDescriptions(it) }
        .let { Single.just(it) }

}

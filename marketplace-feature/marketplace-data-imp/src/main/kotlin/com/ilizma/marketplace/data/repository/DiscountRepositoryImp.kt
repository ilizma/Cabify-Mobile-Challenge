package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.datasource.DiscountDataDataSource
import com.ilizma.marketplace.data.datasource.DiscountDescriptionDataSource
import com.ilizma.marketplace.data.mapper.DiscountDataListMapper
import com.ilizma.marketplace.data.mapper.DiscountDescriptionsMapper
import com.ilizma.marketplace.domain.model.DiscountDataList
import com.ilizma.marketplace.domain.model.DiscountDescriptions
import com.ilizma.marketplace.domain.repository.DiscountRepository
import io.reactivex.rxjava3.core.Single

class DiscountRepositoryImp(
    private val descriptionDataSource: DiscountDescriptionDataSource,
    private val dataDataSource: DiscountDataDataSource,
    private val discountDescriptionsMapper: DiscountDescriptionsMapper,
    private val discountDataListMapper: DiscountDataListMapper,
) : DiscountRepository {

    override fun getDiscountsDescriptions(
    ): Single<DiscountDescriptions> = Single.zip(
        descriptionDataSource.getDiscountDescriptions(),
        dataDataSource.getDiscountDataList(),
    ) { descriptions, dataList ->
        discountDescriptionsMapper.from(descriptions, dataList)
    }

    override fun getDiscounts(
    ): Single<DiscountDataList> = dataDataSource.getDiscountDataList()
        .map { discountDataListMapper.from(it) }

}
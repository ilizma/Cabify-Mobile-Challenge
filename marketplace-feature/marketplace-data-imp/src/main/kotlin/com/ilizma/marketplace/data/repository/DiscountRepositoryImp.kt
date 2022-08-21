package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.datasource.DiscountDataDataSource
import com.ilizma.marketplace.data.datasource.DiscountDescriptionDataSource
import com.ilizma.marketplace.data.mapper.DiscountsMapper
import com.ilizma.marketplace.data.model.DiscountDescriptions
import com.ilizma.marketplace.domain.model.Discounts
import com.ilizma.marketplace.domain.repository.DiscountRepository
import io.reactivex.rxjava3.core.Single

class DiscountRepositoryImp(
    private val descriptionDataSource: DiscountDescriptionDataSource,
    private val dataDataSource: DiscountDataDataSource,
    private val mapper: DiscountsMapper,
) : DiscountRepository {

    override fun getDiscounts(
    ): Single<Discounts> = Single.zip(
        descriptionDataSource.getDiscountDescriptions(),
        dataDataSource.getDiscountDataList(),
    ) { descriptions, dataList ->
        mapper.from(descriptions, dataList)
    }

}
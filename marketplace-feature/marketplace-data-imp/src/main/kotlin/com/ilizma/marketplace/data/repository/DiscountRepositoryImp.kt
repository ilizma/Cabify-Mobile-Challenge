package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.datasource.DiscountDataSource
import com.ilizma.marketplace.data.mapper.DiscountsMapper
import com.ilizma.marketplace.domain.model.Discounts
import com.ilizma.marketplace.domain.repository.DiscountRepository
import io.reactivex.rxjava3.core.Single

class DiscountRepositoryImp(
    private val dataSource: DiscountDataSource,
    private val mapper: DiscountsMapper,
) : DiscountRepository {

    override fun getDiscounts(
    ): Single<Discounts> = dataSource.getDiscounts()
        .map { mapper.from(it) }

}
package com.ilizma.checkout.data.repository

import com.ilizma.checkout.data.datasource.CheckoutDataSource
import com.ilizma.checkout.data.mapper.CheckoutInfoListMapper
import com.ilizma.checkout.domain.model.CheckoutInfoList
import com.ilizma.checkout.domain.repository.CheckoutRepository
import io.reactivex.rxjava3.core.Single

class CheckoutRepositoryImp(
    private val dataSource: CheckoutDataSource,
    private val mapper: CheckoutInfoListMapper,
) : CheckoutRepository {

    override fun getCheckoutInfoList(
    ): Single<CheckoutInfoList> = dataSource.getCheckoutInfoList()
        .map { mapper.from(it) }

}
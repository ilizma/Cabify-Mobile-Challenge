package com.ilizma.checkout.data.repository

import com.ilizma.checkout.data.datasource.CheckoutDataSource
import com.ilizma.checkout.data.mapper.CheckoutInfoListMapper
import com.ilizma.checkout.domain.model.CheckoutInfoList
import com.ilizma.checkout.domain.repository.CheckoutRepository
import io.reactivex.rxjava3.core.Single
import java.util.*

private const val TWO_DECIMAL_FORMAT = "%.2f"

class CheckoutRepositoryImp(
    private val dataSource: CheckoutDataSource,
    private val mapper: CheckoutInfoListMapper,
    private val locale: Locale,
    private val currencySymbolText: String,
) : CheckoutRepository {

    override fun getCheckoutInfoList(
    ): Single<CheckoutInfoList> = dataSource.getCheckoutInfoList()
        .map { mapper.from(it) }

    override fun getTotal(
    ): Single<String> = dataSource.getCheckoutInfoList()
        .map { list ->
            var total = 0f
            list.list.map { total += it.totalPrice }
            String.format(locale, TWO_DECIMAL_FORMAT, total)
                .let { currencySymbolText.format(it) }
        }

}
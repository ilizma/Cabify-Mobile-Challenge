package com.ilizma.checkout.data.repository

import com.ilizma.checkout.data.datasource.CheckoutDataSource
import com.ilizma.checkout.data.mapper.CheckoutInfoListMapper
import com.ilizma.checkout.data.model.CheckoutInfo
import com.ilizma.checkout.domain.model.CheckoutInfoList
import com.ilizma.checkout.domain.repository.CheckoutRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.*
import com.ilizma.checkout.data.model.CheckoutInfoList as DataCheckoutInfoList

internal class CheckoutRepositoryImpTest {

    @RelaxedMockK
    private lateinit var dataSource: CheckoutDataSource

    @RelaxedMockK
    private lateinit var mapper: CheckoutInfoListMapper

    private lateinit var repository: CheckoutRepository
    private val currencySymbolText = "%s€"

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        repository = CheckoutRepositoryImp(
            dataSource = dataSource,
            mapper = mapper,
            locale = Locale.ENGLISH,
            currencySymbolText = currencySymbolText,
        )
    }

    @Nested
    inner class GetCheckoutInfoList {

        @Test
        fun `given DataCheckoutInfoList, when getCheckoutInfoList is called, then result should be the expected CheckoutInfoList`() {
            // given
            val dataCheckoutInfoList = mockk<DataCheckoutInfoList>()
            val expected = mockk<CheckoutInfoList>()
            every { dataSource.getCheckoutInfoList() } returns Single.just(dataCheckoutInfoList)
            every { mapper.from(dataCheckoutInfoList) } returns expected

            // when
            val resultObserver = repository.getCheckoutInfoList()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

    @Nested
    inner class GetTotal {

        @Test
        fun `given DataCheckoutInfoList, when getTotal is called, then result should be the expected String`() {
            // given
            val dataCheckoutInfo = mockk<CheckoutInfo>()
            val dataCheckoutInfoList = listOf(dataCheckoutInfo)
                .let { DataCheckoutInfoList(it) }
            val expected = "19.00€"
            every { dataSource.getCheckoutInfoList() } returns Single.just(dataCheckoutInfoList)
            every { dataCheckoutInfo.totalPrice } returns 19f

            // when
            val resultObserver = repository.getTotal()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}
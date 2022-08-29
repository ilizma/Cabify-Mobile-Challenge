package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.datasource.DiscountDataDataSource
import com.ilizma.marketplace.data.datasource.DiscountDescriptionDataSource
import com.ilizma.marketplace.data.mapper.DiscountDataListMapper
import com.ilizma.marketplace.data.mapper.DiscountDescriptionsMapper
import com.ilizma.marketplace.data.model.DiscountDataList as DataDiscountDataList
import com.ilizma.marketplace.data.model.DiscountDescriptions as DataDiscountDescriptions
import com.ilizma.marketplace.domain.model.DiscountDescriptions
import com.ilizma.marketplace.domain.repository.DiscountRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DiscountRepositoryImpTest {

    @RelaxedMockK
    private lateinit var descriptionDataSource: DiscountDescriptionDataSource

    @RelaxedMockK
    private lateinit var dataDataSource: DiscountDataDataSource

    @RelaxedMockK
    private lateinit var discountDescriptionsMapper: DiscountDescriptionsMapper

    @RelaxedMockK
    private lateinit var discountDataListMapper: DiscountDataListMapper

    private lateinit var repository: DiscountRepository

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        repository = DiscountRepositoryImp(
            descriptionDataSource = descriptionDataSource,
            dataDataSource = dataDataSource,
            discountDescriptionsMapper = discountDescriptionsMapper,
            discountDataListMapper = discountDataListMapper,
        )
    }

    @Nested
    inner class GetDiscountDescriptions {

        @Test
        fun `given DiscountDescriptions and DiscountDataList, when getDiscounts, then result should be the expected Discounts`() {
            // given
            val discountDescriptions = mockk<DataDiscountDescriptions>()
            val discountDataList = mockk<DataDiscountDataList>()
            val expected = mockk<DiscountDescriptions>()
            every { descriptionDataSource.getDiscountDescriptions() } returns Single.just(discountDescriptions)
            every { dataDataSource.getDiscountDataList() } returns Single.just(discountDataList)
            every { discountDescriptionsMapper.from(discountDescriptions, discountDataList) } returns expected

            // when
            val resultObserver = repository.getDiscountsDescriptions()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}
package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.data.model.DiscountData
import com.ilizma.marketplace.data.model.DiscountDataList
import com.ilizma.marketplace.domain.model.DiscountDescription
import com.ilizma.marketplace.domain.model.DiscountDescriptions
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.marketplace.data.model.DiscountDescription as DataDiscountDescription
import com.ilizma.marketplace.data.model.DiscountDescriptions as DataDiscountDescriptions

internal class DiscountDescriptionsMapperTest {

    @RelaxedMockK
    private lateinit var discountDescriptionMapper: DiscountDescriptionMapper

    private lateinit var mapper: DiscountDescriptionsMapper

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = DiscountDescriptionsMapper(
            mapper = discountDescriptionMapper,
        )
    }

    @Nested
    inner class From {

        @Test
        fun `given DiscountDescription, when from is called, then result should be the expected Discounts`() {
            // given
            val discountDescription = mockk<DataDiscountDescription>()
            val discountDescriptions = DataDiscountDescriptions(
                listOf(discountDescription, discountDescription)
            )
            val discountData = mockk<DiscountData>()
            val discountDataList = DiscountDataList(listOf(discountData, discountData))
            val product = mockk<DiscountDescription>()
            val expected = DiscountDescriptions(listOf(product, product))
            every {
                discountDescriptionMapper.from(discountDescription, discountDataList)
            } returns product

            // when
            val result = mapper.from(discountDescriptions, discountDataList)

            // then
            assertEquals(expected, result)
        }

    }

}
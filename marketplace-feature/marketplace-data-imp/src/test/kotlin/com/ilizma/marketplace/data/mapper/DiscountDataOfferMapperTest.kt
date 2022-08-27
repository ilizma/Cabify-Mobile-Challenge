package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.data.model.DiscountData
import com.ilizma.marketplace.data.model.DiscountDataList
import com.ilizma.marketplace.data.model.DiscountDescription
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DiscountDataOfferMapperTest {

    private lateinit var mapper: DiscountDataOfferMapper
    private val discountDataList = DiscountDataList(
        listOf(
            DiscountData.Promotion(quantity = 2, offer = 1),
            DiscountData.Bulk(quantity = 3, offer = 19),
        )
    )

    @BeforeEach
    private fun setup() {
        mapper = DiscountDataOfferMapper()
    }

    @Nested
    inner class From {

        @Test
        fun `given Promotion DiscountDescription and discountDataList, when from is called, then result should be the expected offer`() {
            // given
            val discountDescription = mockk<DiscountDescription.Promotion>()
            val expected = 1

            // when
            val result = mapper.from(discountDescription, discountDataList)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Bulk DiscountDescription and discountDataList, when from is called, then result should be the expected offer`() {
            // given
            val discountDescription = mockk<DiscountDescription.Bulk>()
            val expected = 19

            // when
            val result = mapper.from(discountDescription, discountDataList)

            // then
            assertEquals(expected, result)
        }

    }

}
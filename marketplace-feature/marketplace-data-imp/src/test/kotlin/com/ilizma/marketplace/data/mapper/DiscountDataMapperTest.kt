package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.domain.model.DiscountData
import io.mockk.MockKAnnotations
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.marketplace.data.model.DiscountData as DataDiscountData

internal class DiscountDataMapperTest {

    private lateinit var mapper: DiscountDataMapper

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = DiscountDataMapper()
    }

    @Nested
    inner class From {

        @Test
        fun `given Bulk DiscountData, when from is called, then result should be the expected Bulk DiscountData`() {
            // given
            val dataDiscountData = DataDiscountData.Bulk(quantity = 2, offer = 1)
            val expected = DiscountData.Bulk(quantity = 2, offer = 1)

            // when
            val result = mapper.from(dataDiscountData)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Promotion DiscountData, when from is called, then result should be the expected Promotion DiscountData`() {
            // given
            val dataDiscountData = DataDiscountData.Promotion(quantity = 3, offer = 19)
            val expected = DiscountData.Promotion(quantity = 3, offer = 19)

            // when
            val result = mapper.from(dataDiscountData)

            // then
            assertEquals(expected, result)
        }

    }

}
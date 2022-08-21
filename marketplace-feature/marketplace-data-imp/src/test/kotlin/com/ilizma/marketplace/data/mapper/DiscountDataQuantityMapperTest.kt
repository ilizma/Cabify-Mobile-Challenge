package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.data.model.DiscountData
import com.ilizma.marketplace.data.model.DiscountDataList
import com.ilizma.marketplace.data.model.DiscountDescription
import io.mockk.mockk
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class DiscountDataQuantityMapperTest {

    private lateinit var mapper: DiscountDataQuantityMapper
    private val discountDataList = DiscountDataList(
        listOf(
            DiscountData.Promotion(quantity = 2, offer = 1),
            DiscountData.Bulk(quantity = 3, offer = 19),
        )
    )

    @BeforeEach
    private fun setup() {
        mapper = DiscountDataQuantityMapper()
    }

    @Nested
    inner class From {

        @Test
        fun `given Promotion DiscountDescription and discountDataList, when from is called, then result should be te expected quantity`() {
            // given
            val discountDescription = mockk<DiscountDescription.Promotion>()
            val expected = 2

            // when
            val result = mapper.from(discountDescription, discountDataList)

            // then
            Assertions.assertEquals(expected, result)
        }

        @Test
        fun `given Bulk DiscountDescription and discountDataList, when from is called, then result should be te expected quantity`() {
            // given
            val discountDescription = mockk<DiscountDescription.Bulk>()
            val expected = 3

            // when
            val result = mapper.from(discountDescription, discountDataList)

            // then
            Assertions.assertEquals(expected, result)
        }

    }

}
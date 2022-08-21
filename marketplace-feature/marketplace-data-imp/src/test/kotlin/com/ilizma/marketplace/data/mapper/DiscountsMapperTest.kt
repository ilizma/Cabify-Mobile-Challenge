package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.data.model.DiscountData
import com.ilizma.marketplace.data.model.DiscountDataList
import com.ilizma.marketplace.data.model.DiscountDescription
import com.ilizma.marketplace.data.model.DiscountDescriptions
import com.ilizma.marketplace.domain.model.Discount
import com.ilizma.marketplace.domain.model.Discounts
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DiscountsMapperTest {

    @RelaxedMockK
    private lateinit var productMapper: DiscountDescriptionMapper

    private lateinit var mapper: DiscountsMapper

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = DiscountsMapper(
            mapper = productMapper,
        )
    }

    @Nested
    inner class From {

        @Test
        fun `given DiscountDescription, when from is called, then result should be te expected Discounts`() {
            // given
            val discountDescription = mockk<DiscountDescription>()
            val discountDescriptions = DiscountDescriptions(
                listOf(discountDescription, discountDescription)
            )
            val discountData = mockk<DiscountData>()
            val discountDataList = DiscountDataList(listOf(discountData, discountData))
            val product = mockk<Discount>()
            val expected = Discounts(listOf(product, product))
            every { productMapper.from(discountDescription, discountDataList) } returns product

            // when
            val result = mapper.from(discountDescriptions, discountDataList)

            // then
            assertEquals(expected, result)
        }

    }

}
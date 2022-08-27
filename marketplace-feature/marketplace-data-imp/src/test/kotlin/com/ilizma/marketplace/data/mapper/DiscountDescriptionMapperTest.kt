package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.data.model.DiscountDataList
import com.ilizma.marketplace.data.model.DiscountDescription
import com.ilizma.marketplace.domain.model.DiscountDescription.Bulk
import com.ilizma.marketplace.domain.model.DiscountDescription.Promotion
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DiscountDescriptionMapperTest {

    @RelaxedMockK
    private lateinit var quantityMapper: DiscountDataQuantityMapper

    @RelaxedMockK
    private lateinit var offerMapper: DiscountDataOfferMapper

    private lateinit var mapper: DiscountDescriptionMapper

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = DiscountDescriptionMapper(
            quantityMapper = quantityMapper,
            offerMapper = offerMapper,
        )
    }

    @Nested
    inner class From {

        @Test
        fun `given Promotion DiscountDescription and discountDataList, when from is called, then result should be the expected Promotion`() {
            // given
            val discountDescription = DiscountDescription.Promotion(
                description = "buy %s of the same product, get %s free"
            )
            val discountDataList = mockk<DiscountDataList>()
            val expected = Promotion(
                description = "buy 2 of the same product, get 1 free"
            )
            every { quantityMapper.from(discountDescription, discountDataList) } returns 2
            every { offerMapper.from(discountDescription, discountDataList) } returns 1

            // when
            val result = mapper.from(discountDescription, discountDataList)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Bulk DiscountDescription and discountDataList, when from is called, then result should be the expected Bulk`() {
            // given
            val discountDescription = DiscountDescription.Bulk(
                description = "buying %s or more, the price per unit should be %s€"
            )
            val discountDataList = mockk<DiscountDataList>()
            val expected = Bulk(
                description = "buying 3 or more, the price per unit should be 19€"
            )
            every { quantityMapper.from(discountDescription, discountDataList) } returns 3
            every { offerMapper.from(discountDescription, discountDataList) } returns 19

            // when
            val result = mapper.from(discountDescription, discountDataList)

            // then
            assertEquals(expected, result)
        }

    }

}
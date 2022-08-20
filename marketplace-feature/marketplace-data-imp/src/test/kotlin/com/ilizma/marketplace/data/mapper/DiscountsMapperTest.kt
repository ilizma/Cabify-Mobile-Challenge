package com.ilizma.marketplace.data.mapper

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
import com.ilizma.marketplace.data.model.Discount as DataDiscount
import com.ilizma.marketplace.data.model.Discounts as DataDiscounts

internal class DiscountsMapperTest {

    @RelaxedMockK
    private lateinit var productMapper: DiscountMapper

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
        fun `given DataDiscounts, when from is called, then result should be te expected Discounts`() {
            // given
            val dataDiscount = mockk<DataDiscount>()
            val dataDiscounts = DataDiscounts(listOf(dataDiscount, dataDiscount))
            val product = mockk<Discount>()
            val expected = Discounts(listOf(product, product))
            every { productMapper.from(dataDiscount) } returns product

            // when
            val result = mapper.from(dataDiscounts)

            // then
            assertEquals(expected, result)
        }

    }

}
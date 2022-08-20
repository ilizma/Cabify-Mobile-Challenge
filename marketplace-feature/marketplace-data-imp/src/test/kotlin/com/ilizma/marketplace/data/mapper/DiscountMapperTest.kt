package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.domain.model.Discount.TShirt
import com.ilizma.marketplace.domain.model.Discount.Voucher
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.marketplace.data.model.Discount as DataDiscount

internal class DiscountMapperTest {

    private lateinit var mapper: DiscountMapper

    @BeforeEach
    private fun setup() {
        mapper = DiscountMapper()
    }

    @Nested
    inner class From {

        @Test
        fun `given Voucher DataDiscount, when from is called, then result should be te expected Voucher Discount`() {
            // given
            val dataDiscount = DataDiscount.Voucher(description = "2-for-1")
            val expected = Voucher(description = "2-for-1")

            // when
            val result = mapper.from(dataDiscount)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt DataDiscount, when from is called, then result should be te expected TShirt Discount`() {
            // given
            val dataDiscount = DataDiscount.TShirt(
                description = "buying 3 or more, the price per unit should be 19.00€"
            )
            val expected = TShirt(
                description = "buying 3 or more, the price per unit should be 19.00€"
            )

            // when
            val result = mapper.from(dataDiscount)

            // then
            assertEquals(expected, result)
        }

    }

}
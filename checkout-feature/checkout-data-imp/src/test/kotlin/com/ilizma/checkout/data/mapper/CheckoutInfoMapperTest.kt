package com.ilizma.checkout.data.mapper

import com.ilizma.checkout.domain.model.CheckoutInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.checkout.data.model.CheckoutInfo as DataCheckoutInfo

internal class CheckoutInfoMapperTest {

    private lateinit var mapper: CheckoutInfoMapper

    @BeforeEach
    private fun setup() {
        mapper = CheckoutInfoMapper()
    }

    @Nested
    inner class From {

        @Test
        fun `given Mug DataCheckoutInfo, when from is called, then result should be Mug CheckoutInfo`() {
            // given
            val name = "name"
            val quantity = 1
            val price = "price"
            val dataCheckoutInfo = DataCheckoutInfo.Mug(
                name = name,
                quantity = quantity,
                price = price,
            )
            val expected = CheckoutInfo.Mug(
                name = name,
                quantity = quantity,
                price = price,
            )

            // when
            val result = mapper.from(dataCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt DataCheckoutInfo, when from is called, then result should be TShirt CheckoutInfo`() {
            // given
            val name = "name"
            val quantity = 1
            val price = "price"
            val oldPrice = "oldPrice"
            val dataCheckoutInfo = DataCheckoutInfo.TShirt(
                name = name,
                quantity = quantity,
                price = price,
                oldPrice = oldPrice,
            )
            val expected = CheckoutInfo.TShirt(
                name = name,
                quantity = quantity,
                price = price,
                oldPrice = oldPrice,
            )

            // when
            val result = mapper.from(dataCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Voucher DataCheckoutInfo, when from is called, then result should be Voucher CheckoutInfo`() {
            // given
            val name = "name"
            val quantity = 1
            val price = "price"
            val promotion = "promotion"
            val dataCheckoutInfo = DataCheckoutInfo.Voucher(
                name = name,
                quantity = quantity,
                price = price,
                promotion = promotion,
            )
            val expected = CheckoutInfo.Voucher(
                name = name,
                quantity = quantity,
                price = price,
                promotion = promotion,
            )

            // when
            val result = mapper.from(dataCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

    }

}
package com.ilizma.checkout.presentation.mapper

import com.ilizma.checkout.domain.model.CheckoutInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.checkout.presentation.model.CheckoutInfo as PresentationCheckoutInfo

internal class CheckoutInfoMapperTest {

    private lateinit var mapper: CheckoutInfoMapper

    @BeforeEach
    private fun setup() {
        mapper = CheckoutInfoMapper()
    }

    @Nested
    inner class From {

        @Test
        fun `given Mug CheckoutInfo, when from is called, then result should be Mug PresentationCheckoutInfo`() {
            // given
            val name = "name"
            val quantity = 1
            val price = "price"
            val checkoutInfo = CheckoutInfo.Mug(
                name = name,
                quantity = quantity,
                price = price,
            )
            val expected = PresentationCheckoutInfo.Mug(
                name = name,
                quantity = quantity,
                price = price,
            )

            // when
            val result = mapper.from(checkoutInfo)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt CheckoutInfo, when from is called, then result should be TShirt PresentationCheckoutInfo`() {
            // given
            val name = "name"
            val quantity = 1
            val price = "price"
            val oldPrice = "oldPrice"
            val checkoutInfo = CheckoutInfo.TShirt(
                name = name,
                quantity = quantity,
                price = price,
                oldPrice = oldPrice,
            )
            val expected = PresentationCheckoutInfo.TShirt(
                name = name,
                quantity = quantity,
                price = price,
                oldPrice = oldPrice,
            )

            // when
            val result = mapper.from(checkoutInfo)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Voucher CheckoutInfo, when from is called, then result should be Voucher PresentationCheckoutInfo`() {
            // given
            val name = "name"
            val quantity = 1
            val price = "price"
            val promotion = "promotion"
            val checkoutInfo = CheckoutInfo.Voucher(
                name = name,
                quantity = quantity,
                price = price,
                promotion = promotion,
            )
            val expected = PresentationCheckoutInfo.Voucher(
                name = name,
                quantity = quantity,
                price = price,
                promotion = promotion,
            )

            // when
            val result = mapper.from(checkoutInfo)

            // then
            assertEquals(expected, result)
        }

    }

}
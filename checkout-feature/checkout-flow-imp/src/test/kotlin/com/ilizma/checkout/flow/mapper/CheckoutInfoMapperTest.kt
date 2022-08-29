package com.ilizma.checkout.flow.mapper

import com.ilizma.checkout.data.model.CheckoutInfo
import com.ilizma.checkout.flow.model.ArticleInfoArgs
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class CheckoutInfoMapperTest {

    private lateinit var mapper: CheckoutInfoMapper

    @BeforeEach
    private fun setup() {
        mapper = CheckoutInfoMapper()
    }

    @Nested
    inner class From {

        @Test
        fun `given Mug ArticleInfoArgs, when from is called, then result should be Mug CheckoutInfo`() {
            // given
            val name = "name"
            val quantity = 1
            val price = "price"
            val totalPrice = 19f
            val dataCheckoutInfo = ArticleInfoArgs.Mug(
                name = name,
                quantity = quantity,
                priceWithSymbol = price,
                totalPrice = totalPrice,
            )
            val expected = CheckoutInfo.Mug(
                name = name,
                quantity = quantity,
                priceWithSymbol = price,
                totalPrice = totalPrice,
            )

            // when
            val result = mapper.from(dataCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt ArticleInfoArgs, when from is called, then result should be TShirt CheckoutInfo`() {
            // given
            val name = "name"
            val quantity = 1
            val price = "price"
            val totalPrice = 19f
            val oldPrice = "oldPrice"
            val dataCheckoutInfo = ArticleInfoArgs.TShirt(
                name = name,
                quantity = quantity,
                priceWithSymbol = price,
                oldPrice = oldPrice,
                totalPrice = totalPrice,
            )
            val expected = CheckoutInfo.TShirt(
                name = name,
                quantity = quantity,
                priceWithSymbol = price,
                oldPrice = oldPrice,
                totalPrice = totalPrice,
            )

            // when
            val result = mapper.from(dataCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Voucher ArticleInfoArgs, when from is called, then result should be Voucher CheckoutInfo`() {
            // given
            val name = "name"
            val quantity = 1
            val price = "price"
            val totalPrice = 19f
            val promotion = "promotion"
            val dataCheckoutInfo = ArticleInfoArgs.Voucher(
                name = name,
                quantity = quantity,
                priceWithSymbol = price,
                promotion = promotion,
                totalPrice = totalPrice,
            )
            val expected = CheckoutInfo.Voucher(
                name = name,
                quantity = quantity,
                priceWithSymbol = price,
                promotion = promotion,
                totalPrice = totalPrice,
            )

            // when
            val result = mapper.from(dataCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

    }

}
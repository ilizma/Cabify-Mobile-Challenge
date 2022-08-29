package com.ilizma.checkout.data.mapper

import com.ilizma.checkout.domain.model.CheckoutInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.*
import com.ilizma.checkout.data.model.CheckoutInfo as DataCheckoutInfo

internal class CheckoutInfoMapperTest {

    private lateinit var mapper: CheckoutInfoMapper
    private val currencySymbolText = "%s€"

    @BeforeEach
    private fun setup() {
        mapper = CheckoutInfoMapper(
            locale = Locale.ENGLISH,
            currencySymbolText = currencySymbolText,
        )
    }

    @Nested
    inner class From {

        @Test
        fun `given Mug DataCheckoutInfo, when from is called, then result should be Mug CheckoutInfo`() {
            // given
            val name = "name"
            val quantity = 1
            val price = "price"
            val totalPrice = 19f
            val totalPriceWithSymbol = "19.00€"
            val dataCheckoutInfo = DataCheckoutInfo.Mug(
                name = name,
                quantity = quantity,
                priceWithSymbol = price,
                totalPrice = totalPrice,
            )
            val expected = CheckoutInfo.Mug(
                name = name,
                quantity = quantity,
                priceWithSymbol = price,
                totalPriceWithSymbol = totalPriceWithSymbol,
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
            val totalPrice = 19f
            val totalPriceWithSymbol = "19.00€"
            val oldPrice = "oldPrice"
            val dataCheckoutInfo = DataCheckoutInfo.TShirt(
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
                totalPriceWithSymbol = totalPriceWithSymbol,
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
            val totalPrice = 19f
            val totalPriceWithSymbol = "19.00€"
            val promotion = "promotion"
            val dataCheckoutInfo = DataCheckoutInfo.Voucher(
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
                totalPriceWithSymbol = totalPriceWithSymbol,
            )

            // when
            val result = mapper.from(dataCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

    }

}
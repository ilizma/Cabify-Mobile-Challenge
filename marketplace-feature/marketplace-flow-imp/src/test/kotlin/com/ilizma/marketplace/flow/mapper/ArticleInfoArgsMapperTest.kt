package com.ilizma.marketplace.flow.mapper

import com.ilizma.checkout.flow.model.ArticleInfoArgs
import com.ilizma.marketplace.presentation.model.ArticleCheckoutInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ArticleInfoArgsMapperTest {

    private lateinit var mapper: ArticleInfoArgsMapper

    @BeforeEach
    private fun setup() {
        mapper = ArticleInfoArgsMapper()
    }

    @Nested
    inner class From {

        @Test
        fun `given Mug ArticleCheckoutInfo, when from is called, then result should be the expected ArticleInfoArgs`() {
            // given
            val name = "name"
            val quantity = 1
            val priceWithSymbol = "priceWithSymbol"
            val totalPrice = 19f
            val articleCheckoutInfo = ArticleCheckoutInfo.Mug(
                name = name,
                quantity = quantity,
                priceWithSymbol = priceWithSymbol,
                totalPrice = totalPrice,
            )
            val expected = ArticleInfoArgs.Mug(
                name = name,
                quantity = quantity,
                priceWithSymbol = priceWithSymbol,
                totalPrice = totalPrice,
            )

            // when
            val result = mapper.from(articleCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt ArticleCheckoutInfo, when from is called, then result should be the expected ArticleInfoArgs`() {
            // given
            val name = "name"
            val quantity = 1
            val priceWithSymbol = "priceWithSymbol"
            val totalPrice = 19f
            val oldPrice = "oldPrice"
            val articleCheckoutInfo = ArticleCheckoutInfo.TShirt(
                name = name,
                quantity = quantity,
                priceWithSymbol = priceWithSymbol,
                totalPrice = totalPrice,
                oldPrice = oldPrice,
            )
            val expected = ArticleInfoArgs.TShirt(
                name = name,
                quantity = quantity,
                priceWithSymbol = priceWithSymbol,
                totalPrice = totalPrice,
                oldPrice = oldPrice,
            )

            // when
            val result = mapper.from(articleCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Voucher ArticleCheckoutInfo, when from is called, then result should be the expected ArticleInfoArgs`() {
            // given
            val name = "name"
            val quantity = 1
            val priceWithSymbol = "priceWithSymbol"
            val totalPrice = 19f
            val promotion = "promotion"
            val articleCheckoutInfo = ArticleCheckoutInfo.Voucher(
                name = name,
                quantity = quantity,
                priceWithSymbol = priceWithSymbol,
                totalPrice = totalPrice,
                promotion = promotion,
            )
            val expected = ArticleInfoArgs.Voucher(
                name = name,
                quantity = quantity,
                priceWithSymbol = priceWithSymbol,
                totalPrice = totalPrice,
                promotion = promotion,
            )

            // when
            val result = mapper.from(articleCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

    }

}
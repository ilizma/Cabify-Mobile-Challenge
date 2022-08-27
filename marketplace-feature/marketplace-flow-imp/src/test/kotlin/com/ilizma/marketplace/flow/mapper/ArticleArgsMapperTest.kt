package com.ilizma.marketplace.flow.mapper

import com.ilizma.checkout.flow.model.ArticleArgs
import com.ilizma.marketplace.presentation.model.ArticleCheckoutInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ArticleArgsMapperTest {

    private lateinit var mapper: ArticleArgsMapper

    @BeforeEach
    private fun setup() {
        mapper = ArticleArgsMapper()
    }

    @Nested
    inner class From {

        @Test
        fun `given Mug ArticleCheckoutInfo, when from is called, then result should be the expected ArticleArgs`() {
            // given
            val name = "name"
            val quantity = 1
            val price = "price"
            val articleCheckoutInfo = ArticleCheckoutInfo.Mug(name = name, quantity = quantity, price = price)
            val expected = ArticleArgs.Mug(name = name, quantity = quantity, price = price)

            // when
            val result = mapper.from(articleCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt ArticleCheckoutInfo, when from is called, then result should be the expected ArticleArgs`() {
            // given
            val name = "name"
            val quantity = 1
            val price = "price"
            val oldPrice = "oldPrice"
            val articleCheckoutInfo = ArticleCheckoutInfo.TShirt(name = name, quantity = quantity, price = price, oldPrice = oldPrice)
            val expected = ArticleArgs.TShirt(name = name, quantity = quantity, price = price, oldPrice = oldPrice)

            // when
            val result = mapper.from(articleCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Voucher ArticleCheckoutInfo, when from is called, then result should be the expected ArticleArgs`() {
            // given
            val name = "name"
            val quantity = 1
            val price = "price"
            val promotion = "promotion"
            val articleCheckoutInfo = ArticleCheckoutInfo.Voucher(name = name, quantity = quantity, price = price, promotion = promotion)
            val expected = ArticleArgs.Voucher(name = name, quantity = quantity, price = price, promotion = promotion)

            // when
            val result = mapper.from(articleCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

    }

}
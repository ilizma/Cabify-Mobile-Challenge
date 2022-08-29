package com.ilizma.marketplace.domain.mapper

import com.ilizma.marketplace.domain.model.Article
import com.ilizma.marketplace.domain.model.DiscountDescription
import com.ilizma.marketplace.domain.model.DiscountDescriptions
import com.ilizma.marketplace.domain.model.Product
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ArticleMapperTest {

    private lateinit var mapper: ArticleMapper
    private val tShirtDiscountDescription = "buying 3 or more, the price per unit should be 19€"
    private val voucherDiscountDescription = "2-for-1"
    private val discountDescriptions = DiscountDescriptions(
        list = listOf(
            DiscountDescription.Promotion(description = voucherDiscountDescription),
            DiscountDescription.Bulk(description = tShirtDiscountDescription),
        ),
    )

    @BeforeEach
    private fun setup() {
        mapper = ArticleMapper()
    }

    @Nested
    inner class From {

        @Test
        fun `given Mug Product, when from, then result should be the expected Mug Article`() {
            // given
            val product = Product.Mug(
                name = "Cabify Coffee Mug",
                priceWithSymbol = "7.50€",
                price = 7.5f,
            )
            val expected = Article.Mug(
                name = "Cabify Coffee Mug",
                priceWithSymbol = "7.50€",
            )

            // when
            val result = mapper.from(product, discountDescriptions)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt Product, when from, then result should be the expected TShirt Article`() {
            // given
            val product = Product.TShirt(
                name = "Cabify T-Shirt",
                priceWithSymbol = "20.00€",
                price = 20f,
            )
            val expected = Article.TShirt(
                name = "Cabify T-Shirt",
                priceWithSymbol = "20.00€",
                discountDescription = tShirtDiscountDescription,
            )

            // when
            val result = mapper.from(product, discountDescriptions)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Voucher Product, when from, then result should be the expected Voucher Article`() {
            // given
            val product = Product.Voucher(
                name = "Cabify Voucher",
                priceWithSymbol = "5.00€",
                price = 5f,
            )
            val expected = Article.Voucher(
                name = "Cabify Voucher",
                priceWithSymbol = "5.00€",
                discountDescription = voucherDiscountDescription,
            )

            // when
            val result = mapper.from(product, discountDescriptions)

            // then
            assertEquals(expected, result)
        }

    }

}
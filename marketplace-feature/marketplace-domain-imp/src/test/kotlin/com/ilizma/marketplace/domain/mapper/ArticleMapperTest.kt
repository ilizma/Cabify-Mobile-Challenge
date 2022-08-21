package com.ilizma.marketplace.domain.mapper

import com.ilizma.marketplace.domain.model.Article
import com.ilizma.marketplace.domain.model.Discount
import com.ilizma.marketplace.domain.model.Discounts
import com.ilizma.marketplace.domain.model.Product
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ArticleMapperTest {

    private lateinit var mapper: ArticleMapper
    private val tShirtDiscountDescription = "buying 3 or more, the price per unit should be 19.00€"
    private val voucherDiscountDescription = "2-for-1"
    private val discounts = Discounts(
        list = listOf(
            Discount.Promotion(description = voucherDiscountDescription),
            Discount.Bulk(description = tShirtDiscountDescription),
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
            val product = Product.Mug(name = "Cabify Coffee Mug", price = "7.5€")
            val expected = Article.Mug(name = "Cabify Coffee Mug", price = "7.5€")

            // when
            val result = mapper.from(product, discounts)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt Product, when from, then result should be the expected TShirt Article`() {
            // given
            val product = Product.TShirt(
                name = "Cabify T-Shirt",
                price = "20€",
            )
            val expected = Article.TShirt(
                name = "Cabify T-Shirt",
                price = "20€",
                discountDescription = tShirtDiscountDescription,
            )

            // when
            val result = mapper.from(product, discounts)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Voucher Product, when from, then result should be the expected Voucher Article`() {
            // given
            val product = Product.Voucher(
                name = "Cabify Voucher",
                price = "5€",
            )
            val expected = Article.Voucher(
                name = "Cabify Voucher",
                price = "5€",
                discountDescription = voucherDiscountDescription,
            )

            // when
            val result = mapper.from(product, discounts)

            // then
            assertEquals(expected, result)
        }

    }

}
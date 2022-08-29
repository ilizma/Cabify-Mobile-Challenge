package com.ilizma.marketplace.presentation.mapper

import com.ilizma.marketplace.domain.model.ArticleCheckoutInfo
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.marketplace.presentation.model.ArticleCheckoutInfo as PresentationArticleCheckoutInfo

class ArticleCheckoutInfoMapperTest {

    private lateinit var mapper: ArticleCheckoutInfoMapper

    @BeforeEach
    private fun setup() {
        mapper = ArticleCheckoutInfoMapper()
    }

    @Nested
    inner class From {

        @Test
        fun `given Mug Article, when from, then result should be the expected Mug PresentationArticle`() {
            // given
            val article = ArticleCheckoutInfo.Mug(
                name = "Cabify Coffee Mug",
                priceWithSymbol = "7.50€",
                quantity = 1,
                totalPrice = 19f,
            )
            val expected = PresentationArticleCheckoutInfo.Mug(
                name = "Cabify Coffee Mug",
                priceWithSymbol = "7.50€",
                quantity = 1,
                totalPrice = 19f,
            )

            // when
            val result = mapper.from(article)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt Article, when from, then result should be the expected TShirt PresentationArticle`() {
            // given
            val article = ArticleCheckoutInfo.TShirt(
                name = "Cabify T-Shirt",
                priceWithSymbol = "20.00€",
                quantity = 1,
                totalPrice = 19f,
                oldPrice = "20.00€",
            )
            val expected = PresentationArticleCheckoutInfo.TShirt(
                name = "Cabify T-Shirt",
                priceWithSymbol = "20.00€",
                quantity = 1,
                totalPrice = 19f,
                oldPrice = "20.00€",
            )

            // when
            val result = mapper.from(article)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Voucher Article, when from, then result should be the expected Voucher PresentationArticle`() {
            // given
            val article = ArticleCheckoutInfo.Voucher(
                name = "Cabify Voucher",
                priceWithSymbol = "5.00€",
                quantity = 1,
                totalPrice = 19f,
                promotion = "2x1",
            )
            val expected = PresentationArticleCheckoutInfo.Voucher(
                name = "Cabify Voucher",
                priceWithSymbol = "5.00€",
                quantity = 1,
                totalPrice = 19f,
                promotion = "2x1",
            )

            // when
            val result = mapper.from(article)

            // then
            assertEquals(expected, result)
        }

    }

}
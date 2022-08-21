package com.ilizma.marketplace.presentation.mapper

import com.ilizma.marketplace.domain.model.Article
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.marketplace.presentation.model.Article as PresentationArticle

internal class ArticleMapperTest {

    private lateinit var mapper: ArticleMapper

    @BeforeEach
    private fun setup() {
        mapper = ArticleMapper()
    }

    @Nested
    inner class From {

        @Test
        fun `given Mug Article, when from, then result should be the expected Mug PresentationArticle`() {
            // given
            val article = Article.Mug(name = "Cabify Coffee Mug", price = "7.50€")
            val expected = PresentationArticle.Success.Mug(name = "Cabify Coffee Mug", price = "7.50€")

            // when
            val result = mapper.from(article)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt Article, when from, then result should be the expected TShirt PresentationArticle`() {
            // given
            val article = Article.TShirt(
                name = "Cabify T-Shirt",
                price = "20.00€",
                discountDescription = "buying 3 or more, the price per unit should be 19€",
            )
            val expected = PresentationArticle.Success.TShirt(
                name = "Cabify T-Shirt",
                price = "20.00€",
                discountDescription = "buying 3 or more, the price per unit should be 19€",
            )

            // when
            val result = mapper.from(article)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Voucher Article, when from, then result should be the expected Voucher PresentationArticle`() {
            // given
            val article = Article.Voucher(
                name = "Cabify Voucher",
                price = "5.00€",
                discountDescription = "2-for-1",
            )
            val expected = PresentationArticle.Success.Voucher(
                name = "Cabify Voucher",
                price = "5.00€",
                discountDescription = "2-for-1",
            )

            // when
            val result = mapper.from(article)

            // then
            assertEquals(expected, result)
        }

    }

}
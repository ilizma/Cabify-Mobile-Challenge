package com.ilizma.marketplace.domain.mapper

import com.ilizma.marketplace.domain.model.*
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class ArticlesMapperTest {

    @RelaxedMockK
    private lateinit var articleMapper: ArticleMapper

    private lateinit var mapper: ArticlesMapper

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = ArticlesMapper(
            mapper = articleMapper,
        )
    }

    @Nested
    inner class From {

        @Test
        fun `given Products and Discounts, when from, then result should be the expected Articles`() {
            // given
            val product = mockk<Product>()
            val products = Products(list = listOf(product, product))
            val discounts = Discounts(list = listOf(mockk()))
            val article = mockk<Article>()
            val expected = Articles(list = listOf(article, article))
            every { articleMapper.from(product, discounts) } returns article

            // when
            val result = mapper.from(products, discounts)

            // then
            assertEquals(expected, result)
        }

    }

}
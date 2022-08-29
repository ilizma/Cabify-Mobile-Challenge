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

internal class ArticlesStateMapperTest {

    @RelaxedMockK
    private lateinit var articleMapper: ArticleMapper

    private lateinit var mapper: ArticlesStateMapper

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = ArticlesStateMapper(
            mapper = articleMapper,
        )
    }

    @Nested
    inner class From {

        @Test
        fun `given Success ProductsState and Discounts, when from, then result should be the expected Success Articles`() {
            // given
            val product = mockk<Product>()
            val state = ProductsState.Success(list = listOf(product, product))
            val discountDescriptions = DiscountDescriptions(list = listOf(mockk()))
            val article = mockk<Article>()
            val expected = ArticlesState.Success(list = listOf(article, article))
            every { articleMapper.from(product, discountDescriptions) } returns article

            // when
            val result = mapper.from(state, discountDescriptions)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given RemoteError ProductsState and Discounts, when from, then result should be the expected RemoteError Articles`() {
            // given
            val errorMessage = "errorMessage"
            val state = ProductsState.RemoteError(errorMessage)
            val discountDescriptions = DiscountDescriptions(list = listOf(mockk()))
            val expected = ArticlesState.RemoteError(errorMessage)

            // when
            val result = mapper.from(state, discountDescriptions)

            // then
            assertEquals(expected, result)
        }

    }

}
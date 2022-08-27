package com.ilizma.marketplace.flow.mapper

import com.ilizma.checkout.flow.model.ArticleArgs
import com.ilizma.checkout.flow.model.ArticlesArgs
import com.ilizma.marketplace.presentation.model.ArticleCheckoutInfo
import com.ilizma.marketplace.presentation.model.ArticlesCheckoutInfo
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ArticlesArgsMapperTest {

    @RelaxedMockK
    private lateinit var articleArgsMapper: ArticleArgsMapper

    private lateinit var mapper: ArticlesArgsMapper

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = ArticlesArgsMapper(
            mapper = articleArgsMapper,
        )
    }

    @Nested
    inner class From {

        @Test
        fun `given ArticleCheckoutInfo, when from is called, then result should be the expected ArticleArgs`() {
            // given
            val articlesCheckoutInfo = mockk<ArticlesCheckoutInfo>()
            val articleCheckoutInfo = mockk<ArticleCheckoutInfo>()
            val articleArgs = mockk<ArticleArgs>()
            val expected = ArticlesArgs(listOf(articleArgs))
            every { articlesCheckoutInfo.list } returns listOf(articleCheckoutInfo)
            every { articleArgsMapper.from(articleCheckoutInfo) } returns articleArgs

            // when
            val result = mapper.from(articlesCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

    }

}
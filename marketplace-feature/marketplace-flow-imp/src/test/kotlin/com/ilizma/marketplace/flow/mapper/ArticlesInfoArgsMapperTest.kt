package com.ilizma.marketplace.flow.mapper

import com.ilizma.checkout.flow.model.ArticleInfoArgs
import com.ilizma.checkout.flow.model.ArticlesInfoArgs
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

internal class ArticlesInfoArgsMapperTest {

    @RelaxedMockK
    private lateinit var articleInfoArgsMapper: ArticleInfoArgsMapper

    private lateinit var mapper: ArticlesInfoArgsMapper

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = ArticlesInfoArgsMapper(
            mapper = articleInfoArgsMapper,
        )
    }

    @Nested
    inner class From {

        @Test
        fun `given ArticleCheckoutInfo, when from is called, then result should be the expected ArticleInfoArgs`() {
            // given
            val articlesCheckoutInfo = mockk<ArticlesCheckoutInfo>()
            val articleCheckoutInfo = mockk<ArticleCheckoutInfo>()
            val articleInfoArgs = mockk<ArticleInfoArgs>()
            val expected = ArticlesInfoArgs(listOf(articleInfoArgs))
            every { articlesCheckoutInfo.list } returns listOf(articleCheckoutInfo)
            every { articleInfoArgsMapper.from(articleCheckoutInfo) } returns articleInfoArgs

            // when
            val result = mapper.from(articlesCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

    }

}
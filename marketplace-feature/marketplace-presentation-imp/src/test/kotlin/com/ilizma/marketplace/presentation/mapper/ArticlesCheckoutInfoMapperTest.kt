package com.ilizma.marketplace.presentation.mapper

import com.ilizma.marketplace.domain.model.ArticleCheckoutInfo
import com.ilizma.marketplace.domain.model.ArticlesCheckoutInfo
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.marketplace.presentation.model.ArticleCheckoutInfo as PresentationArticleCheckoutInfo
import com.ilizma.marketplace.presentation.model.ArticlesCheckoutInfo as PresentationArticlesCheckoutInfo

class ArticlesCheckoutInfoMapperTest {

    @RelaxedMockK
    private lateinit var articleCheckoutInfoMapper: ArticleCheckoutInfoMapper

    private lateinit var mapper: ArticlesCheckoutInfoMapper

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = ArticlesCheckoutInfoMapper(
            mapper = articleCheckoutInfoMapper,
        )
    }

    @Nested
    inner class From {

        @Test
        fun `given ArticlesCheckoutInfo, when from, then result should be the expected Mug PresentationArticlesCheckoutInfo`() {
            // given
            val articleCheckoutInfo = mockk<ArticleCheckoutInfo>()
            val presentationArticleCheckoutInfo = mockk<PresentationArticleCheckoutInfo>()
            val articlesCheckoutInfo = ArticlesCheckoutInfo(listOf(articleCheckoutInfo))
            val expected = PresentationArticlesCheckoutInfo(listOf(presentationArticleCheckoutInfo))
            every { articleCheckoutInfoMapper.from(articleCheckoutInfo) } returns presentationArticleCheckoutInfo

            // when
            val result = mapper.from(articlesCheckoutInfo)

            // then
            assertEquals(expected, result)
        }

    }

}
package com.ilizma.marketplace.presentation.mapper

import com.ilizma.marketplace.domain.model.Article
import com.ilizma.marketplace.domain.model.ArticlesState
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.marketplace.presentation.model.Article as PresentationArticle
import com.ilizma.marketplace.presentation.model.ArticlesState as PresentationArticlesState

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
        fun `given success articlesState, when from, then result should be the expected success PresentationArticlesState`() {
            // given
            val article = mockk<Article>()
            val articlesState = ArticlesState.Success(listOf(article, article))
            val presentationArticle = mockk<PresentationArticle.Success>()
            val expected = PresentationArticlesState.Success(
                listOf(presentationArticle, presentationArticle)
            )
            every { articleMapper.from(article) } returns presentationArticle

            // when
            val result = mapper.from(articlesState)

            // then
            assertEquals(expected, result)
        }

    }

}
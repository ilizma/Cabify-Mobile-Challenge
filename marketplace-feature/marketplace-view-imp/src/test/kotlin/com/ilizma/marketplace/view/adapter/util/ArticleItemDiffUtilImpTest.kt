package com.ilizma.marketplace.view.adapter.util

import com.ilizma.marketplace.presentation.model.Article
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ArticleItemDiffUtilImpTest {

    private lateinit var articleItemDiffUtil: ArticleItemDiffUtil<Article>

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        articleItemDiffUtil = ArticleItemDiffUtilImp()
    }

    @Nested
    inner class AreItemsTheSame {

        @Test
        fun `given oldItem and newItem as Loading, when areItemsTheSame is called, then result should be the expected true`() {
            // given
            val oldItem = Article.Loading
            val newItem = Article.Loading
            val expected = true

            // when
            val result = articleItemDiffUtil.areItemsTheSame(
                oldItem,
                newItem,
            )

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given oldItem and newItem as Success with the same name, when areItemsTheSame is called, then result should be the expected true`() {
            // given
            val name = "name"
            val oldItem = mockk<Article.Success>()
            val newItem = mockk<Article.Success>()
            val expected = true
            every { oldItem.name } returns name
            every { newItem.name } returns name

            // when
            val result = articleItemDiffUtil.areItemsTheSame(
                oldItem,
                newItem,
            )

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Loading oldItem and Success newItem, when areItemsTheSame is called, then result should be the expected false`() {
            // given
            val oldItem = Article.Loading
            val newItem = mockk<Article.Success>()
            val expected = false

            // when
            val result = articleItemDiffUtil.areItemsTheSame(
                oldItem,
                newItem,
            )

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Success oldItem and Loading newItem, when areItemsTheSame is called, then result should be the expected false`() {
            // given
            val oldItem = mockk<Article.Success>()
            val newItem = Article.Loading
            val expected = false

            // when
            val result = articleItemDiffUtil.areItemsTheSame(
                oldItem,
                newItem,
            )

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given oldItem and newItem as Success with different names, when areItemsTheSame is called, then result should be the expected false`() {
            // given
            val name = "name"
            val otherName = "otherName"
            val oldItem = mockk<Article.Success>()
            val newItem = mockk<Article.Success>()
            val expected = false
            every { oldItem.name } returns name
            every { newItem.name } returns otherName

            // when
            val result = articleItemDiffUtil.areItemsTheSame(
                oldItem,
                newItem,
            )

            // then
            assertEquals(expected, result)
        }

    }

    @Nested
    inner class AreContentsTheSame {

        @Test
        fun `given same oldItem and newItem, when areContentsTheSame is called, then result should be the expected true`() {
            // given
            val item = mockk<Article>()
            val expected = true

            // when
            val result = articleItemDiffUtil.areContentsTheSame(
                item,
                item,
            )

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given different oldItem and newItem, when areContentsTheSame is called, then result should be the expected false`() {
            // given
            val oldItem = mockk<Article>()
            val newItem = mockk<Article>()
            val expected = false

            // when
            val result = articleItemDiffUtil.areContentsTheSame(
                oldItem,
                newItem,
            )

            // then
            assertEquals(expected, result)
        }

    }

}
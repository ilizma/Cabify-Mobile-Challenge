package com.ilizma.marketplace.view.mapper

import com.ilizma.marketplace.view.model.ArticleType
import io.mockk.MockKAnnotations
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ArticleTypeMapperTest {

    private lateinit var mapper: ArticleTypeMapper

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = ArticleTypeMapper()
    }

    @Nested
    inner class From {

        @Test
        fun `given TYPE_ITEM viewType, when from is called, then result should be the expected ArticleType`() {
            // given
            val viewType = ArticleType.TYPE_ITEM.ordinal
            val expected = ArticleType.TYPE_ITEM

            // when
            val result = mapper.from(viewType)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TYPE_LOADING viewType, when from is called, then result should be the expected ArticleType`() {
            // given
            val viewType = ArticleType.TYPE_LOADING.ordinal
            val expected = ArticleType.TYPE_LOADING

            // when
            val result = mapper.from(viewType)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given wrong viewType, when from is called, then throws an exception`() {
            // given
            val viewType = -1

            // when, then
            assertThrows<IllegalArgumentException> { mapper.from(viewType) }
        }

    }

}
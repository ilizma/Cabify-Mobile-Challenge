package com.ilizma.marketplace.data.cache

import com.ilizma.marketplace.data.model.ProductsState
import io.mockk.MockKAnnotations
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ProductSuccessCacheImpTest {

    private lateinit var cache: ProductSuccessCache

    init {
        MockKAnnotations.init(this)
    }

    private fun initCache(
        productCache: ProductsState.Success?,
    ) {
        cache = ProductSuccessCacheImp(
            cache = productCache,
        )
    }

    @Nested
    inner class Get {

        @Test
        fun `given Success ProductsState, when get, then result should be the expected Success ProductsState`() {
            // given
            val expected = mockk<ProductsState.Success>()
            initCache(expected)

            // when
            val result = cache.get()

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given null ProductsState, when get, then result should be the expected null`() {
            // given
            val expected = null
            initCache(expected)

            // when
            val result = cache.get()

            // then
            assertEquals(expected, result)
        }

    }

    @Nested
    inner class Set {

        @Test
        fun `given null cached, when set, then get should be the expected Success ProductsState`() {
            // given
            val expected = mockk<ProductsState.Success>()
            initCache(null)

            // when
            cache.set(expected)

            // then
            assertEquals(expected, cache.get())
        }

    }

}
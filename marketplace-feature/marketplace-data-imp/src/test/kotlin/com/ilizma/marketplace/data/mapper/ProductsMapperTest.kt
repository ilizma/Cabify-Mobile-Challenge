package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.data.model.ProductsState
import com.ilizma.marketplace.domain.model.Product
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.marketplace.data.model.Product as DataProduct

internal class ProductsMapperTest {

    @RelaxedMockK
    private lateinit var productMapper: ProductMapper

    private lateinit var mapper: ProductsMapper

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = ProductsMapper(
            mapper = productMapper
        )
    }

    @Nested
    inner class From {

        @Test
        fun `given Success ProductsState, when from is called, then result should be the expected Product`() {
            // given
            val state = mockk<ProductsState.Success>()
            val dataProduct = mockk<DataProduct>()
            val product = mockk<Product>()
            val expected = listOf(product)
            every { state.list } returns listOf(dataProduct)
            every { productMapper.from(dataProduct) } returns product

            // when
            val result = mapper.from(state)

            // then
            assertEquals(expected, result)

        }

    }

}
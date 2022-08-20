package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.domain.model.Product
import com.ilizma.marketplace.domain.model.Products
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.marketplace.data.model.Product as DataProduct
import com.ilizma.marketplace.data.model.Products as DataProducts

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
            mapper = productMapper,
        )
    }

    @Nested
    inner class From {

        @Test
        fun `given DataProducts, when from is called, then result should be te expected Products`() {
            // given
            val dataProduct = mockk<DataProduct>()
            val dataProducts = DataProducts(listOf(dataProduct, dataProduct))
            val product = mockk<Product>()
            val expected = Products(listOf(product, product))
            every { productMapper.from(dataProduct) } returns product

            // when
            val result = mapper.from(dataProducts)

            // then
            assertEquals(expected, result)
        }

    }

}
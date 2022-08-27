package com.ilizma.marketplace.data.mapper

import com.ilizma.api.model.ProductDTO
import com.ilizma.api.model.ProductsDTO
import com.ilizma.marketplace.domain.model.Product
import com.ilizma.marketplace.domain.model.ProductsState
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import retrofit2.adapter.rxjava3.Result
import com.ilizma.marketplace.data.model.Product as DataProduct
import com.ilizma.marketplace.data.model.ProductsState as DataProductsState

internal class ProductsStateMapperTest {

    @RelaxedMockK
    private lateinit var productMapper: ProductMapper

    private lateinit var mapper: ProductsStateMapper
    private val unknownErrorMessage = "unknownErrorMessage"

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = ProductsStateMapper(
            mapper = productMapper,
            unknownErrorMessage = unknownErrorMessage,
        )
    }

    @Nested
    inner class From {

        @Nested
        inner class Dto {

            @Test
            fun `given Result ProductsDTO, when from is called, then result should be the expected Success DataProductsState`() {
                // given
                val productDTO = mockk<ProductDTO>()
                val resultDTO = mockk<Result<ProductsDTO>>()
                val product = mockk<DataProduct>()
                val expected = DataProductsState.Success(listOf(product, product))
                every { resultDTO.isError } returns false
                every { resultDTO.response()?.body()?.products } returns listOf(productDTO, productDTO)
                every { productMapper.from(productDTO) } returns product

                // when
                val result = mapper.from(resultDTO)

                // then
                assertEquals(expected, result)
            }

            @Test
            fun `given Result ProductsDTO with null products, when from is called, then result should be the expected RemoteError DataProductsState`() {
                // given
                val resultDTO = mockk<Result<ProductsDTO>>()
                val expected = DataProductsState.RemoteError(unknownErrorMessage)
                every { resultDTO.isError } returns false
                every { resultDTO.response()?.body()?.products } returns null

                // when
                val result = mapper.from(resultDTO)

                // then
                assertEquals(expected, result)
            }

            @Test
            fun `given Result ProductsDTO with null body, when from is called, then result should be the expected RemoteError DataProductsState`() {
                // given
                val resultDTO = mockk<Result<ProductsDTO>>()
                val expected = DataProductsState.RemoteError(unknownErrorMessage)
                every { resultDTO.isError } returns false
                every { resultDTO.response()?.body() } returns null

                // when
                val result = mapper.from(resultDTO)

                // then
                assertEquals(expected, result)
            }

            @Test
            fun `given Result ProductsDTO with null response, when from is called, then result should be the expected RemoteError DataProductsState`() {
                // given
                val resultDTO = mockk<Result<ProductsDTO>>()
                val expected = DataProductsState.RemoteError(unknownErrorMessage)
                every { resultDTO.isError } returns false
                every { resultDTO.response() } returns null

                // when
                val result = mapper.from(resultDTO)

                // then
                assertEquals(expected, result)
            }

            @Test
            fun `given error Result ProductsDTO with errorMessage, when from is called, then result should be the expected RemoteError DataProductsState`() {
                // given
                val errorMessage = "errorMessage"
                val resultDTO = mockk<Result<ProductsDTO>>()
                val expected = DataProductsState.RemoteError(errorMessage)
                every { resultDTO.isError } returns true
                every { resultDTO.error()?.message } returns errorMessage

                // when
                val result = mapper.from(resultDTO)

                // then
                assertEquals(expected, result)
            }

            @Test
            fun `given error Result ProductsDTO with null errorMessage, when from is called, then result should be the expected RemoteError DataProductsState`() {
                // given
                val errorMessage = null
                val resultDTO = mockk<Result<ProductsDTO>>()
                val expected = DataProductsState.RemoteError("")
                every { resultDTO.isError } returns true
                every { resultDTO.error()?.message } returns errorMessage

                // when
                val result = mapper.from(resultDTO)

                // then
                assertEquals(expected, result)
            }

        }

        @Nested
        inner class Data {

            @Test
            fun `given Success DataProductsState, when from is called, then result should be the expected Success ProductsState`() {
                // given
                val dataProduct = mockk<DataProduct>()
                val dataProducts = DataProductsState.Success(listOf(dataProduct, dataProduct))
                val product = mockk<Product>()
                val expected = ProductsState.Success(listOf(product, product))
                every { productMapper.from(dataProduct) } returns product

                // when
                val result = mapper.from(dataProducts)

                // then
                assertEquals(expected, result)
            }

            @Test
            fun `given RemoteError DataProductsState, when from is called, then result should be the expected RemoteError ProductsState`() {
                // given
                val errorMessage = "errorMessage"
                val dataProducts = DataProductsState.RemoteError(errorMessage)
                val expected = ProductsState.RemoteError(errorMessage)

                // when
                val result = mapper.from(dataProducts)

                // then
                assertEquals(expected, result)
            }

        }

    }

}
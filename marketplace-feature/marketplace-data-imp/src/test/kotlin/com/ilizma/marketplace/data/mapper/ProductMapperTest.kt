package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.domain.model.Product.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.marketplace.data.model.Product as DataProduct

internal class ProductMapperTest {

    private lateinit var mapper: ProductMapper

    @BeforeEach
    private fun setup() {
        mapper = ProductMapper()
    }

    @Nested
    inner class From {

        @Test
        fun `given Voucher DataProduct, when from is called, then result should be te expected Voucher Product`() {
            // given
            val dataProduct = DataProduct.Voucher(name = "Cabify Voucher", price = "5€")
            val expected = Voucher(name = "Cabify Voucher", price = "5€")

            // when
            val result = mapper.from(dataProduct)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt DataProduct, when from is called, then result should be te expected TShirt Product`() {
            // given
            val dataProduct = DataProduct.TShirt(name = "Cabify T-Shirt", price = "20€")
            val expected = TShirt(name = "Cabify T-Shirt", price = "20€")

            // when
            val result = mapper.from(dataProduct)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Mug DataProduct, when from is called, then result should be te expected Mug Product`() {
            // given
            val dataProduct = DataProduct.Mug(name = "Cabify T-Shirt", price = "20€")
            val expected = Mug(name = "Cabify Coffee Mug", price = "7.5€")

            // when
            val result = mapper.from(dataProduct)

            // then
            assertEquals(expected, result)
        }

    }

}
package com.ilizma.marketplace.domain.mapper

import com.ilizma.marketplace.domain.model.ArticleCheckoutInfo
import com.ilizma.marketplace.domain.model.ArticlesCheckoutInfo
import com.ilizma.marketplace.domain.model.DiscountDataList
import com.ilizma.marketplace.domain.model.Product
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ArticlesCheckoutInfoMapperTest {

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
        fun `given Success ProductsState and Discounts, when from, then result should be the expected Success Articles`() {
            // given
            val product = mockk<Product>()
            val products = listOf(product)
            val productQuantityList = listOf<Pair<Product, Int>>()
            val discountDataList = mockk<DiscountDataList>()
            val articleCheckoutInfo = mockk<ArticleCheckoutInfo>()
            val expected = ArticlesCheckoutInfo(listOf(articleCheckoutInfo))
            every {
                articleCheckoutInfoMapper.from(
                    product = product,
                    productQuantityList = productQuantityList,
                    discounts = discountDataList,
                )
            } returns articleCheckoutInfo

            // when
            val result = mapper.from(products, productQuantityList, discountDataList)

            // then
            assertEquals(expected, result)
        }

    }

}
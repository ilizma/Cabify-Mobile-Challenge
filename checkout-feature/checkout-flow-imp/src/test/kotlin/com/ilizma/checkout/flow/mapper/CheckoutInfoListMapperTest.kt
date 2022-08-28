package com.ilizma.checkout.flow.mapper

import com.ilizma.checkout.data.model.CheckoutInfo
import com.ilizma.checkout.data.model.CheckoutInfoList
import com.ilizma.checkout.flow.model.ArticleArgs
import com.ilizma.checkout.flow.model.ArticlesArgs
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CheckoutInfoListMapperTest {

    @RelaxedMockK
    private lateinit var checkoutInfoMapper: CheckoutInfoMapper

    private lateinit var mapper: CheckoutInfoListMapper

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = CheckoutInfoListMapper(
            mapper = checkoutInfoMapper,
        )
    }

    @Nested
    inner class From {

        @Test
        fun `given ArticlesArgs, when from is called, then result should be CheckoutInfoList`() {
            // given
            val articleArgs = mockk<ArticleArgs>()
            val checkoutInfo = mockk<CheckoutInfo>()
            val dataCheckoutInfoList = ArticlesArgs(listOf(articleArgs))
            val expected = CheckoutInfoList(listOf(checkoutInfo))
            every { checkoutInfoMapper.from(articleArgs) } returns checkoutInfo

            // when
            val result = mapper.from(dataCheckoutInfoList)

            // then
            assertEquals(expected, result)
        }

    }

}
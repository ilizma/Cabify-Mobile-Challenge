package com.ilizma.checkout.data.mapper

import com.ilizma.checkout.domain.model.CheckoutInfo
import com.ilizma.checkout.domain.model.CheckoutInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.checkout.data.model.CheckoutInfo as DataCheckoutInfo
import com.ilizma.checkout.data.model.CheckoutInfoList as DataCheckoutInfoList

internal class CheckoutInfoListMapperTest {

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
        fun `given DataCheckoutInfoList, when from is called, then result should be CheckoutInfoList`() {
            // given
            val dataCheckoutInfo = mockk<DataCheckoutInfo>()
            val checkoutInfo = mockk<CheckoutInfo>()
            val dataCheckoutInfoList = DataCheckoutInfoList(listOf(dataCheckoutInfo))
            val expected = CheckoutInfoList(listOf(checkoutInfo))
            every { checkoutInfoMapper.from(dataCheckoutInfo) } returns checkoutInfo

            // when
            val result = mapper.from(dataCheckoutInfoList)

            // then
            assertEquals(expected, result)
        }

    }

}
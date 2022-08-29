package com.ilizma.checkout.presentation.mapper

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
import com.ilizma.checkout.presentation.model.CheckoutInfo as PresentationCheckoutInfo
import com.ilizma.checkout.presentation.model.CheckoutInfoList as PresentationCheckoutInfoList

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
        fun `given CheckoutInfoList, when from is called, then result should be PresentationCheckoutInfoList`() {
            // given
            val checkoutInfo = mockk<CheckoutInfo>()
            val presentationCheckoutInfo = mockk<PresentationCheckoutInfo>()
            val checkoutInfoList = CheckoutInfoList(listOf(checkoutInfo))
            val expected = PresentationCheckoutInfoList(listOf(presentationCheckoutInfo))
            every { checkoutInfoMapper.from(checkoutInfo) } returns presentationCheckoutInfo

            // when
            val result = mapper.from(checkoutInfoList)

            // then
            assertEquals(expected, result)
        }

    }

}
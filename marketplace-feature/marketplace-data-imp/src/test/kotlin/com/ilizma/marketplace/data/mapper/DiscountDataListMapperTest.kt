package com.ilizma.marketplace.data.mapper

import com.ilizma.marketplace.domain.model.DiscountData
import com.ilizma.marketplace.domain.model.DiscountDataList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.marketplace.data.model.DiscountData as DataDiscountData
import com.ilizma.marketplace.data.model.DiscountDataList as DataDiscountDataList

internal class DiscountDataListMapperTest {

    @RelaxedMockK
    private lateinit var discountDataMapper: DiscountDataMapper

    private lateinit var mapper: DiscountDataListMapper

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = DiscountDataListMapper(
            mapper = discountDataMapper,
        )
    }

    @Nested
    inner class From {

        @Test
        fun `given DataDiscountDataList, when from is called, then result should be the expected DiscountDataList`() {
            // given
            val dataDiscountDataList = mockk<DataDiscountDataList>()
            val dataDiscountData = mockk<DataDiscountData>()
            val discountData = mockk<DiscountData>()
            val expected = DiscountDataList(listOf(discountData))
            every { dataDiscountDataList.list } returns listOf(dataDiscountData)
            every { discountDataMapper.from(dataDiscountData) } returns discountData

            // when
            val result = mapper.from(dataDiscountDataList)

            // then
            assertEquals(expected, result)
        }

    }

}
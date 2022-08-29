package com.ilizma.marketplace.data.datasource

import com.ilizma.marketplace.data.model.DiscountData
import com.ilizma.marketplace.data.model.DiscountDataList
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DiscountDataDataSourceImpTest {

    private lateinit var dataSource: DiscountDataDataSource

    @BeforeEach
    private fun setup() {
        dataSource = DiscountDataDataSourceImp()
    }

    @Nested
    inner class GetDiscountDataList {

        @Test
        fun `when getDiscountDataList, then result should be the expected DiscountDataList`() {
            // given
            val expected = DiscountDataList(
                listOf(
                    DiscountData.Promotion(quantity = 2, offer = 1),
                    DiscountData.Bulk(quantity = 3, offer = 19),
                )
            )

            // when
            val resultObserver = dataSource.getDiscountDataList()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}
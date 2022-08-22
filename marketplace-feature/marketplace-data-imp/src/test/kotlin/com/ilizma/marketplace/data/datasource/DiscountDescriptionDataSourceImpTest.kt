package com.ilizma.marketplace.data.datasource

import com.ilizma.marketplace.data.model.DiscountDescription
import com.ilizma.marketplace.data.model.DiscountDescriptions
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class DiscountDescriptionDataSourceImpTest {

    private lateinit var dataSource: DiscountDescriptionDataSource
    private val promotionText = "buy %s of the same product, get %s free"
    private val bulkText = "buying %s or more, the price per unit should be %s€"

    @BeforeEach
    private fun setup() {
        dataSource = DiscountDescriptionDataSourceImp(
            promotionText = promotionText,
            bulkText = bulkText,
        )
    }

    @Nested
    inner class GetDiscountDescriptions {

        @Test
        fun `when getDiscountDescriptions, then result should be the expected DiscountDescriptions`() {
            // given
            val expected = DiscountDescriptions(
                listOf(
                    DiscountDescription.Promotion(promotionText),
                    DiscountDescription.Bulk(bulkText),
                )
            )

            // when
            val resultObserver = dataSource.getDiscountDescriptions()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}
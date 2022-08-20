package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.datasource.DiscountDataSource
import com.ilizma.marketplace.data.mapper.DiscountsMapper
import com.ilizma.marketplace.domain.model.Discounts
import com.ilizma.marketplace.domain.repository.DiscountRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.marketplace.data.model.Discounts as DataDiscounts

internal class DiscountRepositoryImpTest {

    @RelaxedMockK
    private lateinit var dataSource: DiscountDataSource

    @RelaxedMockK
    private lateinit var mapper: DiscountsMapper

    private lateinit var repository: DiscountRepository

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        repository = DiscountRepositoryImp(
            dataSource = dataSource,
            mapper = mapper,
        )
    }

    @Nested
    inner class GetDiscounts {

        @Test
        fun `given DataDiscounts, when getPlayerName, then result should be the expected Discounts`() {
            // given
            val dataDiscounts = mockk<DataDiscounts>()
            val expected = mockk<Discounts>()
            every { dataSource.getDiscounts() } returns Single.just(dataDiscounts)
            every { mapper.from(dataDiscounts) } returns expected

            // when
            val resultObserver = repository.getDiscounts()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}
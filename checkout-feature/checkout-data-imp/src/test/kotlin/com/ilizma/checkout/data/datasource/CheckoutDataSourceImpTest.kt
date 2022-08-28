package com.ilizma.checkout.data.datasource

import com.ilizma.checkout.data.model.CheckoutInfoList
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class CheckoutDataSourceImpTest {

    @RelaxedMockK
    private lateinit var checkoutInfoList: () -> CheckoutInfoList

    private lateinit var dataSource: CheckoutDataSource

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        dataSource = CheckoutDataSourceImp(
            checkoutInfoList = checkoutInfoList,
        )
    }

    @Nested
    inner class GetCheckoutInfoList {

        @Test
        fun `given CheckoutInfoList, when getCheckoutInfoList is called, then result should be the expected CheckoutInfoList`() {
            // given
            val expected = mockk<CheckoutInfoList>()
            every { checkoutInfoList() } returns expected

            // when
            val resultObserver = dataSource.getCheckoutInfoList()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}
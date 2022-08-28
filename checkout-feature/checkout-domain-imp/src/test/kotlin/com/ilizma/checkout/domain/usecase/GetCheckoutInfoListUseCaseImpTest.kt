package com.ilizma.checkout.domain.usecase

import com.ilizma.checkout.domain.model.CheckoutInfoList
import com.ilizma.checkout.domain.repository.CheckoutRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class GetCheckoutInfoListUseCaseImpTest {

    @RelaxedMockK
    private lateinit var repository: CheckoutRepository

    private lateinit var useCase: GetCheckoutInfoListUseCase

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        useCase = GetCheckoutInfoListUseCaseImp(
            repository,
        )
    }

    @Nested
    inner class Invoke {

        @Test
        fun `given expected CheckoutInfoList, when invoked, then result should be the expected`() {
            // given
            val expected = mockk<CheckoutInfoList>()
            every { repository.getCheckoutInfoList() } returns Single.just(expected)

            // when
            val resultObserver = useCase()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}
package com.ilizma.checkout.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ilizma.checkout.domain.model.CheckoutInfoList
import com.ilizma.checkout.domain.usecase.GetCheckoutInfoListUseCase
import com.ilizma.checkout.domain.usecase.GetTotalUseCase
import com.ilizma.checkout.presentation.mapper.CheckoutInfoListMapper
import com.ilizma.checkout.presentation.model.CheckoutNavigationAction
import com.ilizma.presentation.SingleLiveEvent
import com.ilizma.test.executor.InstantExecutorExtension
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import com.ilizma.checkout.presentation.model.CheckoutInfoList as PresentationCheckoutInfoList

@ExtendWith(InstantExecutorExtension::class)
internal class CheckoutViewModelImpTest {

    @RelaxedMockK
    private lateinit var getCheckoutInfoListUseCase: GetCheckoutInfoListUseCase

    @RelaxedMockK
    private lateinit var getTotalUseCase: GetTotalUseCase

    @RelaxedMockK
    private lateinit var mapper: CheckoutInfoListMapper

    @RelaxedMockK
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var viewModel: CheckoutViewModel

    init {
        MockKAnnotations.init(this)
    }

    private fun initViewModel() {
        viewModel = CheckoutViewModelImp(
            getCheckoutInfoListUseCase = getCheckoutInfoListUseCase,
            getTotalUseCase = getTotalUseCase,
            mapper = mapper,
            backgroundScheduler = Schedulers.trampoline(),
            compositeDisposable = compositeDisposable,
            _list = MutableLiveData(),
            _total = MutableLiveData(),
            _navigationAction = SingleLiveEvent(),
        )
    }

    @Nested
    inner class Init {

        @Nested
        inner class GetCheckoutInfoList {

            @Test
            fun `given CheckoutInfoList, when viewModel is initialized, then the list liveData value should be the expected`() {
                // given
                val checkoutInfoList = mockk<CheckoutInfoList>()
                val expected = mockk<PresentationCheckoutInfoList>()
                every { getCheckoutInfoListUseCase() } returns Single.just(checkoutInfoList)
                every { mapper.from(checkoutInfoList) } returns expected

                // when
                initViewModel()

                // then
                assertEquals(expected, viewModel.list.value)
            }

        }

        @Nested
        inner class GetTotal {

            @Test
            fun `given expected string, when viewModel is initialized, then the total liveData value should be the expected`() {
                // given
                val expected = "19.00???"
                every { getTotalUseCase() } returns Single.just(expected)

                // when
                initViewModel()

                // then
                assertEquals(expected, viewModel.total.value)
            }

        }

    }

    @Nested
    inner class OnBack {

        @Test
        fun `when onBack is executed, then the navigationAction liveData should be the expected`() {
            // given
            val expected = CheckoutNavigationAction.BACK
            initViewModel()

            // when
            viewModel.onBack()

            // then
            assertEquals(expected, viewModel.navigationAction.value)
        }

    }

}
package com.ilizma.marketplace.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ilizma.marketplace.domain.model.ArticlesState
import com.ilizma.marketplace.domain.usecase.GetArticlesStateUseCase
import com.ilizma.marketplace.presentation.mapper.ArticlesStateMapper
import com.ilizma.marketplace.presentation.model.MarketplaceNavigationAction
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
import com.ilizma.marketplace.presentation.model.ArticlesState as PresentationArticlesState

@ExtendWith(InstantExecutorExtension::class)
internal class MarketplaceViewModelImpTest {

    @RelaxedMockK
    private lateinit var useCase: GetArticlesStateUseCase

    @RelaxedMockK
    private lateinit var mapper: ArticlesStateMapper

    @RelaxedMockK
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var viewModel: MarketplaceViewModel

    init {
        MockKAnnotations.init(this)
    }

    private fun initViewModel() {
        viewModel = MarketplaceViewModelImp(
            useCase = useCase,
            mapper = mapper,
            backgroundScheduler = Schedulers.trampoline(),
            compositeDisposable = compositeDisposable,
            _state = MutableLiveData(),
            _error = MutableLiveData(),
            _navigationAction = SingleLiveEvent(),
        )
    }

    @Nested
    inner class Init {

        @Test
        fun `given Success ArticlesState, when viewModel is initialized, then the state liveData value should be the expected Success`() {
            // given
            val state = mockk<ArticlesState.Success>()
            val expected = mockk<PresentationArticlesState.Success>()
            every { useCase() } returns Single.just(state)
            every { mapper.from(state) } returns expected

            // when
            initViewModel()

            // then
            assertEquals(expected, viewModel.state.value)
        }

        @Test
        fun `given RemoteError ArticlesState, when viewModel is initialized, then the error liveData value should be the expected errorMessage`() {
            // given
            val expected = "errorMessage"
            val state = mockk<ArticlesState.RemoteError>()
            every { useCase() } returns Single.just(state)
            every { state.message } returns expected

            // when
            initViewModel()

            // then
            assertEquals(expected, viewModel.error.value)
        }

    }

    @Nested
    inner class OnCheckout {

        @Test
        fun `when onCheckout, then the navigationAction liveData value should be the expected CHECKOUT MarketplaceNavigationAction`() {
            // given
            val expected = MarketplaceNavigationAction.CHECKOUT
            initViewModel()

            // when
            viewModel.onCheckout()

            // then
            assertEquals(expected, viewModel.navigationAction.value)
        }

    }

}
package com.ilizma.marketplace.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ilizma.marketplace.domain.model.ArticlesCheckoutInfo
import com.ilizma.marketplace.domain.model.ArticlesState
import com.ilizma.marketplace.domain.usecase.GetArticlesCheckoutInfoUseCase
import com.ilizma.marketplace.domain.usecase.GetArticlesStateUseCase
import com.ilizma.marketplace.presentation.mapper.ArticlesCheckoutInfoMapper
import com.ilizma.marketplace.presentation.mapper.ArticlesStateMapper
import com.ilizma.marketplace.presentation.model.CheckoutState
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
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import com.ilizma.marketplace.presentation.model.ArticlesCheckoutInfo as PresentationArticlesCheckoutInfo
import com.ilizma.marketplace.presentation.model.ArticlesState as PresentationArticlesState

@ExtendWith(InstantExecutorExtension::class)
internal class MarketplaceViewModelImpTest {

    @RelaxedMockK
    private lateinit var getArticlesStateUseCase: GetArticlesStateUseCase

    @RelaxedMockK
    private lateinit var getArticlesCheckoutInfoUseCase: GetArticlesCheckoutInfoUseCase

    @RelaxedMockK
    private lateinit var articlesStateMapper: ArticlesStateMapper

    @RelaxedMockK
    private lateinit var articlesCheckoutInfoMapper: ArticlesCheckoutInfoMapper

    @RelaxedMockK
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var viewModel: MarketplaceViewModel

    init {
        MockKAnnotations.init(this)
    }

    private fun initViewModel() {
        viewModel = MarketplaceViewModelImp(
            getArticlesStateUseCase = getArticlesStateUseCase,
            getArticlesCheckoutInfoUseCase = getArticlesCheckoutInfoUseCase,
            articlesStateMapper = articlesStateMapper,
            articlesCheckoutInfoMapper = articlesCheckoutInfoMapper,
            backgroundScheduler = Schedulers.trampoline(),
            compositeDisposable = compositeDisposable,
            _state = MutableLiveData(),
            _error = MutableLiveData(),
            _checkoutState = MutableLiveData(),
            _navigationAction = SingleLiveEvent(),
        )
    }

    @Nested
    inner class Init {

        @Nested
        inner class Loading {

            @Test
            fun `when viewModel is initialized, then the state liveData value should be the expected Loading`() {
                // when
                initViewModel()

                // then
                assertTrue(viewModel.state.value is PresentationArticlesState.Loading)
            }
        }

        @Nested
        inner class GetArticlesStateUseCase {

            @Test
            fun `given Success ArticlesState, when viewModel is initialized, then the state liveData value should be the expected Success`() {
                // given
                val state = mockk<ArticlesState.Success>()
                val expected = mockk<PresentationArticlesState.Success>()
                every { getArticlesStateUseCase() } returns Single.just(state)
                every { articlesStateMapper.from(state) } returns expected

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
                every { getArticlesStateUseCase() } returns Single.just(state)
                every { state.message } returns expected

                // when
                initViewModel()

                // then
                assertEquals(expected, viewModel.error.value)
            }

        }

    }

    @Nested
    inner class GetState {

        @Nested
        inner class Loading {

            @Test
            fun `when viewModel is initialized, then the state liveData value should be the expected Loading`() {
                // given
                initViewModel()

                // when
                viewModel.getState()

                // then
                assertTrue(viewModel.state.value is PresentationArticlesState.Loading)
            }
        }

        @Nested
        inner class GetArticlesStateUseCase {

            @Test
            fun `given Success ArticlesState, when viewModel is initialized, then the state liveData value should be the expected Success`() {
                // given
                val state = mockk<ArticlesState.Success>()
                val expected = mockk<PresentationArticlesState.Success>()
                every { getArticlesStateUseCase() } returns Single.just(state)
                every { articlesStateMapper.from(state) } returns expected
                initViewModel()

                // when
                viewModel.getState()

                // then
                assertEquals(expected, viewModel.state.value)
            }

            @Test
            fun `given RemoteError ArticlesState, when viewModel is initialized, then the error liveData value should be the expected errorMessage`() {
                // given
                val expected = "errorMessage"
                val state = mockk<ArticlesState.RemoteError>()
                every { getArticlesStateUseCase() } returns Single.just(state)
                every { state.message } returns expected
                initViewModel()

                // when
                viewModel.getState()

                // then
                assertEquals(expected, viewModel.error.value)
            }

        }

    }

    @Nested
    inner class OnCheckout {

        @Test
        fun `when onCheckout, then the navigationAction liveData value should be the expected CHECKOUT MarketplaceNavigationAction`() {
            // given
            val articlesCheckoutInfo = mockk<ArticlesCheckoutInfo>()
            val presentationArticlesCheckoutInfo = mockk<PresentationArticlesCheckoutInfo>()
            val expectedCheckoutState = CheckoutState.NONE
            val expected = MarketplaceNavigationAction.Checkout(presentationArticlesCheckoutInfo)
            every { getArticlesCheckoutInfoUseCase() } returns Single.just(articlesCheckoutInfo)
            every { articlesCheckoutInfoMapper.from(articlesCheckoutInfo) } returns presentationArticlesCheckoutInfo
            initViewModel()

            // when
            viewModel.onCheckout()

            // then
            assertEquals(expectedCheckoutState, viewModel.checkoutState.value)
            assertEquals(expected, viewModel.navigationAction.value)
        }

    }

}
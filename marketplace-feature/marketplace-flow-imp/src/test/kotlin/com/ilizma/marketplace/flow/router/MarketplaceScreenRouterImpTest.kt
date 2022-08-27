package com.ilizma.marketplace.flow.router

import androidx.activity.OnBackPressedDispatcher
import androidx.lifecycle.LifecycleOwner
import com.ilizma.checkout.flow.model.ArticlesArgs
import com.ilizma.checkout.flow.navigator.CheckoutNavigator
import com.ilizma.marketplace.flow.mapper.ArticlesArgsMapper
import com.ilizma.marketplace.presentation.model.ArticlesCheckoutInfo
import com.ilizma.marketplace.presentation.model.MarketplaceNavigationAction
import com.ilizma.marketplace.presentation.viewmodel.MarketplaceViewModel
import com.ilizma.marketplace.view.router.MarketplaceScreenRouter
import com.ilizma.test.lifecycle.TestMutableLiveData
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class MarketplaceScreenRouterImpTest {

    @RelaxedMockK
    private lateinit var lifecycleOwner: LifecycleOwner

    @RelaxedMockK
    private lateinit var onBackPressedDispatcher: OnBackPressedDispatcher

    @RelaxedMockK
    private lateinit var viewModel: MarketplaceViewModel

    @RelaxedMockK
    private lateinit var viewModelLazy: Lazy<MarketplaceViewModel>

    @RelaxedMockK
    private lateinit var navigator: CheckoutNavigator

    @RelaxedMockK
    private lateinit var mapper: ArticlesArgsMapper

    private lateinit var router: MarketplaceScreenRouter

    init {
        MockKAnnotations.init(this)
        every { viewModelLazy.value } returns viewModel
    }

    @BeforeEach
    private fun setup() {
        router = MarketplaceScreenRouterImp(
            lifecycleOwner = { lifecycleOwner },
            onBackPressedDispatcher = onBackPressedDispatcher,
            viewModelLazy = viewModelLazy,
            navigator = navigator,
            mapper = mapper,
        )
    }

    @Nested
    inner class Init {

        @Test
        fun `when router is initialized, then viewModel functions are called`() {
            // when
            router.init()

            // then
            verify { viewModel.navigationAction.observe(any(), any()) }
        }

        @Nested
        inner class NavigationAction {

            @Test
            fun `given a Checkout GameScreenNavigationAction, when liveData navigationAction is updated, then navigateFromGame is called`() {
                // given
                val navigationAction = mockk<MarketplaceNavigationAction.Checkout>()
                val articlesCheckoutInfo = mockk<ArticlesCheckoutInfo>()
                val articlesArgs = mockk<ArticlesArgs>()
                val navigationActions = TestMutableLiveData<MarketplaceNavigationAction>()
                every { viewModel.navigationAction } returns navigationActions
                every { navigationAction.articlesCheckoutInfo } returns articlesCheckoutInfo
                every { mapper.from(articlesCheckoutInfo) } returns articlesArgs

                // when
                router.init()
                navigationActions.onChanged(navigationAction)

                // then
                verify { navigator.navigate(articlesArgs) }
            }

        }

    }

}
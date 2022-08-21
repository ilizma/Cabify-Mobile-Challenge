package com.ilizma.game.flow.router

import androidx.activity.OnBackPressedDispatcher
import androidx.lifecycle.LifecycleOwner
import com.ilizma.game.flow.navigator.StartNavigator
import com.ilizma.game.flow.navigator.WinnerNavigator
import com.ilizma.game.presentation.model.GameScreenNavigationAction
import com.ilizma.marketplace.flow.router.MarketplaceScreenRouterImp
import com.ilizma.marketplace.presentation.viewmodel.MarketplaceViewModel
import com.ilizma.marketplace.view.router.MarketplaceScreenRouter
import com.ilizma.test.lifecycle.TestMutableLiveData
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
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
    private lateinit var winnerNavigator: WinnerNavigator

    @RelaxedMockK
    private lateinit var startNavigator: StartNavigator

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
            winnerNavigator = winnerNavigator,
            startNavigator = startNavigator,
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
            fun `given a Reset GameScreenNavigationAction, when liveData navigationAction is updated, then navigateFromGame is called`() {
                // given
                val navigationAction = GameScreenNavigationAction.Reset
                val navigationActions = TestMutableLiveData<GameScreenNavigationAction>()
                every { viewModel.navigationAction } returns navigationActions

                // when
                router.init()
                navigationActions.onChanged(navigationAction)

                // then
                verify { startNavigator.navigateFromGame() }
            }

            @Test
            fun `given a Winner GameScreenNavigationAction, when liveData navigationAction is updated, then navigate is called`() {
                // given
                val winnerName = "winnerName"
                val navigationAction = GameScreenNavigationAction.Winner(winnerName)
                val navigationActions = TestMutableLiveData<GameScreenNavigationAction>()
                every { viewModel.navigationAction } returns navigationActions

                // when
                router.init()
                navigationActions.onChanged(navigationAction)

                // then
                verify { winnerNavigator.navigate(winnerName) }
            }

        }

    }

}
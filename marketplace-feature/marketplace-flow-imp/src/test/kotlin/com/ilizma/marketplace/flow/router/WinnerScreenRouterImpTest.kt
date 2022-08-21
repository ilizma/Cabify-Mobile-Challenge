package com.ilizma.game.flow.router

import androidx.activity.OnBackPressedDispatcher
import androidx.lifecycle.LifecycleOwner
import com.ilizma.game.flow.navigator.ExitNavigator
import com.ilizma.game.flow.navigator.StartNavigator
import com.ilizma.game.presentation.model.WinnerScreenNavigationAction
import com.ilizma.game.presentation.viewmodel.WinnerScreenViewModel
import com.ilizma.game.view.router.WinnerScreenRouter
import com.ilizma.test.lifecycle.TestMutableLiveData
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class WinnerScreenRouterImpTest {

    @RelaxedMockK
    private lateinit var lifecycleOwner: LifecycleOwner

    @RelaxedMockK
    private lateinit var onBackPressedDispatcher: OnBackPressedDispatcher

    @RelaxedMockK
    private lateinit var viewModel: WinnerScreenViewModel

    @RelaxedMockK
    private lateinit var viewModelLazy: Lazy<WinnerScreenViewModel>

    @RelaxedMockK
    private lateinit var exitNavigator: ExitNavigator

    @RelaxedMockK
    private lateinit var startNavigator: StartNavigator

    private lateinit var router: WinnerScreenRouter

    init {
        MockKAnnotations.init(this)
        every { viewModelLazy.value } returns viewModel
    }

    @BeforeEach
    private fun setup() {
        router = WinnerScreenRouterImp(
            lifecycleOwner = { lifecycleOwner },
            onBackPressedDispatcher = onBackPressedDispatcher,
            viewModelLazy = viewModelLazy,
            exitNavigator = exitNavigator,
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
            fun `given a Restart WinnerScreenNavigationAction, when liveData navigationAction is updated, then navigateFromWinner is called`() {
                // given
                val navigationAction = WinnerScreenNavigationAction.Restart
                val navigationActions = TestMutableLiveData<WinnerScreenNavigationAction>()
                every { viewModel.navigationAction } returns navigationActions

                // when
                router.init()
                navigationActions.onChanged(navigationAction)

                // then
                verify { startNavigator.navigateFromWinner() }
            }

            @Test
            fun `given a Exit WinnerScreenNavigationAction, when liveData navigationAction is updated, then navigate is called`() {
                // given
                val navigationAction = WinnerScreenNavigationAction.Exit
                val navigationActions = TestMutableLiveData<WinnerScreenNavigationAction>()
                every { viewModel.navigationAction } returns navigationActions

                // when
                router.init()
                navigationActions.onChanged(navigationAction)

                // then
                verify { exitNavigator.navigate() }
            }

        }

    }

}
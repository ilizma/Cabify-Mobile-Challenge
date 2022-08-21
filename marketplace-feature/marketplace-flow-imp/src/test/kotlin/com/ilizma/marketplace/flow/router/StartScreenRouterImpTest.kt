package com.ilizma.game.flow.router

import androidx.activity.OnBackPressedDispatcher
import androidx.lifecycle.LifecycleOwner
import com.ilizma.game.flow.navigator.GameNavigator
import com.ilizma.game.presentation.model.StartScreenNavigationAction
import com.ilizma.game.presentation.viewmodel.StartScreenViewModel
import com.ilizma.game.view.router.StartScreenRouter
import com.ilizma.test.lifecycle.TestMutableLiveData
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class StartScreenRouterImpTest {

    @RelaxedMockK
    private lateinit var lifecycleOwner: LifecycleOwner

    @RelaxedMockK
    private lateinit var onBackPressedDispatcher: OnBackPressedDispatcher

    @RelaxedMockK
    private lateinit var viewModel: StartScreenViewModel

    @RelaxedMockK
    private lateinit var viewModelLazy: Lazy<StartScreenViewModel>

    @RelaxedMockK
    private lateinit var navigator: GameNavigator

    private lateinit var router: StartScreenRouter

    init {
        MockKAnnotations.init(this)
        every { viewModelLazy.value } returns viewModel
    }

    @BeforeEach
    private fun setup() {
        router = StartScreenRouterImp(
            lifecycleOwner = { lifecycleOwner },
            onBackPressedDispatcher = onBackPressedDispatcher,
            viewModelLazy = viewModelLazy,
            navigator = navigator,
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
            fun `given a Game StartScreenNavigationAction, when liveData navigationAction is updated, then navigate is called`() {
                // given
                val player1Name = "player1Name"
                val player2Name = "player2Name"
                val navigationAction = StartScreenNavigationAction.Game(
                    player1Name = player1Name,
                    player2Name = player2Name,
                )
                val navigationActions = TestMutableLiveData<StartScreenNavigationAction>()
                every { viewModel.navigationAction } returns navigationActions

                // when
                router.init()
                navigationActions.onChanged(navigationAction)

                // then
                verify { navigator.navigate(player1Name = player1Name, player2Name = player2Name) }
            }

        }

    }

}
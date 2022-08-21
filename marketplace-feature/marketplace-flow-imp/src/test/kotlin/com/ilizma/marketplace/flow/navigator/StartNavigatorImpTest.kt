package com.ilizma.game.flow.navigator

import androidx.navigation.NavController
import com.ilizma.game.view.fragment.GameScreenFragmentDirections
import com.ilizma.game.view.fragment.WinnerScreenFragmentDirections
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class StartNavigatorImpTest {

    @RelaxedMockK
    private lateinit var navController: NavController

    private lateinit var navigator: StartNavigator

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    fun setup() {
        navigator = StartNavigatorImp(
            navController = { navController },
        )
    }

    @Nested
    inner class NavigateFromGame {

        @Test
        fun `when navigateFromGame is called, then navigate is executed`() {
            // when
            navigator.navigateFromGame()

            // then
            verify { navController.navigate(GameScreenFragmentDirections.goFromGameToStart()) }
        }

    }

    @Nested
    inner class NavigateFromWinner {

        @Test
        fun `when navigateFromWinner is called, then navigate is executed`() {
            // when
            navigator.navigateFromWinner()

            // then
            verify { navController.navigate(WinnerScreenFragmentDirections.goFromWinnerToStart()) }
        }

    }

}
package com.ilizma.game.flow.navigator

import androidx.navigation.NavController
import com.ilizma.game.view.fragment.GameScreenFragmentDirections
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class WinnerNavigatorImpTest {

    @RelaxedMockK
    private lateinit var navController: NavController

    private lateinit var navigator: WinnerNavigator

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    fun setup() {
        navigator = WinnerNavigatorImp(
            navController = { navController },
        )
    }

    @Nested
    inner class Navigate {

        @Test
        fun `when navigate is called, then navigate is executed`() {
            // given
            val winnerName = "winnerName"

            // when
            navigator.navigate(winnerName)

            // then
            verify {
                navController.navigate(GameScreenFragmentDirections.goFromGameToWinner(winnerName))
            }
        }

    }

}
package com.ilizma.game.flow.navigator

import androidx.navigation.NavController
import com.ilizma.game.view.fragment.StartScreenFragmentDirections
import com.ilizma.game.view.model.GameStartArgs
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class GameNavigatorImpTest {

    @RelaxedMockK
    private lateinit var navController: NavController

    private lateinit var navigator: GameNavigator

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    fun setup() {
        navigator = GameNavigatorImp(
            navController = { navController },
        )
    }

    @Nested
    inner class Navigate {

        @Test
        fun `when navigate is called, then navigate is executed`() {
            //given
            val player1Name = "player1Name"
            val player2Name = "player2Name"

            // when
            navigator.navigate(
                player1Name = player1Name,
                player2Name = player2Name,
            )

            // then
            verify { navController.navigate(StartScreenFragmentDirections.goFromStartToGame(GameStartArgs(player1Name, player2Name))) }
        }

    }

}
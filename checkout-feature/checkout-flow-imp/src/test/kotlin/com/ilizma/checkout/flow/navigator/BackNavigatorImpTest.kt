package com.ilizma.checkout.flow.navigator

import androidx.navigation.NavController
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class BackNavigatorImpTest {

    @RelaxedMockK
    private lateinit var navController: NavController

    private lateinit var navigator: BackNavigator

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        navigator = BackNavigatorImp(
            navController = navController,
        )
    }

    @Nested
    inner class Navigate {

        @Test
        fun `when navigate is called, then navController popBackStack is called`() {
            // when
            navigator.navigate()

            // then
            verify { navController.popBackStack() }
        }

    }

}
package com.ilizma.checkout.flow.navigator

import androidx.navigation.NavController
import com.ilizma.checkout.flow.model.ArticlesInfoArgs
import com.ilizma.marketplace.view.fragment.MarketplaceScreenFragmentDirections.Companion.goFromMarketplaceToCheckout
import io.mockk.MockKAnnotations
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CheckoutNavigatorImpTest {

    @RelaxedMockK
    private lateinit var navController: NavController

    private lateinit var navigator: CheckoutNavigator

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        navigator = CheckoutNavigatorImp(
            navController = { navController },
        )
    }

    @Nested
    inner class Navigate {

        @Test
        fun `when navigate is called, then navController navigate is called`() {
            // given
            val args = mockk<ArticlesInfoArgs>()

            // when
            navigator.navigate(args)

            // then
            verify { navController.navigate(goFromMarketplaceToCheckout(args)) }
        }

    }

}
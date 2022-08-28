package com.ilizma.checkout.flow.router

import androidx.activity.OnBackPressedDispatcher
import androidx.lifecycle.LifecycleOwner
import com.ilizma.checkout.flow.navigator.BackNavigator
import com.ilizma.checkout.presentation.model.CheckoutNavigationAction
import com.ilizma.checkout.presentation.viewmodel.CheckoutViewModel
import com.ilizma.checkout.view.router.CheckoutScreenRouter
import com.ilizma.test.lifecycle.TestMutableLiveData
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class CheckoutScreenRouterImpTest {

    @RelaxedMockK
    private lateinit var lifecycleOwner: LifecycleOwner

    @RelaxedMockK
    private lateinit var onBackPressedDispatcher: OnBackPressedDispatcher

    @RelaxedMockK
    private lateinit var viewModel: CheckoutViewModel

    @RelaxedMockK
    private lateinit var viewModelLazy: Lazy<CheckoutViewModel>

    @RelaxedMockK
    private lateinit var navigator: BackNavigator

    private lateinit var router: CheckoutScreenRouter

    init {
        MockKAnnotations.init(this)
        every { viewModelLazy.value } returns viewModel
    }

    @BeforeEach
    private fun setup() {
        router = CheckoutScreenRouterImp(
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
            fun `given a BACK CheckoutNavigationAction, when liveData navigationAction is updated, then backNavigator navigate is called`() {
                // given
                val navigationAction = CheckoutNavigationAction.BACK
                val navigationActions = TestMutableLiveData<CheckoutNavigationAction>()
                every { viewModel.navigationAction } returns navigationActions

                // when
                router.init()
                navigationActions.onChanged(navigationAction)

                // then
                verify { navigator.navigate() }
            }

        }

    }

}
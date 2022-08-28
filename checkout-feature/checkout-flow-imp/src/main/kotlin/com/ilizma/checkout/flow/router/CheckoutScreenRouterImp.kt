package com.ilizma.checkout.flow.router

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.lifecycle.LifecycleOwner
import com.ilizma.checkout.flow.navigator.BackNavigator
import com.ilizma.checkout.presentation.model.CheckoutNavigationAction
import com.ilizma.checkout.presentation.viewmodel.CheckoutViewModel
import com.ilizma.checkout.view.router.CheckoutScreenRouter

class CheckoutScreenRouterImp(
    private val lifecycleOwner: () -> LifecycleOwner,
    private val onBackPressedDispatcher: OnBackPressedDispatcher,
    viewModelLazy: Lazy<CheckoutViewModel>,
    private val navigator: BackNavigator,
) : CheckoutScreenRouter {

    private val viewModel by viewModelLazy

    private val onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            viewModel.onBack()
        }
    }

    override fun init() {
        viewModel.navigationAction.observe(
            lifecycleOwner(),
        ) { onNavigationAction(it) }

        onBackPressedDispatcher.addCallback(lifecycleOwner(), onBackPressedCallback)
    }

    private fun onNavigationAction(
        action: CheckoutNavigationAction,
    ) {
        when (action) {
            CheckoutNavigationAction.BACK -> navigator.navigate()
        }
    }

}
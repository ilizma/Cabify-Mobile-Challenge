package com.ilizma.marketplace.flow.router

import androidx.activity.OnBackPressedCallback
import androidx.activity.OnBackPressedDispatcher
import androidx.lifecycle.LifecycleOwner
import com.ilizma.checkout.flow.navigator.CheckoutNavigator
import com.ilizma.marketplace.flow.mapper.ArticlesArgsMapper
import com.ilizma.marketplace.flow.navigator.BackNavigator
import com.ilizma.marketplace.presentation.model.MarketplaceNavigationAction
import com.ilizma.marketplace.presentation.viewmodel.MarketplaceViewModel
import com.ilizma.marketplace.view.router.MarketplaceScreenRouter

class MarketplaceScreenRouterImp(
    private val lifecycleOwner: () -> LifecycleOwner,
    private val onBackPressedDispatcher: OnBackPressedDispatcher,
    viewModelLazy: Lazy<MarketplaceViewModel>,
    private val checkoutNavigator: CheckoutNavigator,
    private val backNavigator: BackNavigator,
    private val mapper: ArticlesArgsMapper,
) : MarketplaceScreenRouter {

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
        action: MarketplaceNavigationAction,
    ) {
        when (action) {
            is MarketplaceNavigationAction.Checkout -> mapper.from(action.articlesCheckoutInfo)
                .let { checkoutNavigator.navigate(it) }
            MarketplaceNavigationAction.Back -> backNavigator.navigate()
        }
    }

}
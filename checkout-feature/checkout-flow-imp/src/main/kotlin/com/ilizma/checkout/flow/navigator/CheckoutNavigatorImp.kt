package com.ilizma.checkout.flow.navigator

import androidx.navigation.NavController
import com.ilizma.checkout.flow.model.ArticlesInfoArgs
import com.ilizma.marketplace.view.fragment.MarketplaceScreenFragmentDirections.Companion.goFromMarketplaceToCheckout

class CheckoutNavigatorImp(
    private val navController: () -> NavController,
) : CheckoutNavigator {

    override fun navigate(
        args: ArticlesInfoArgs,
    ) {
        goFromMarketplaceToCheckout(args)
            .let { navController().navigate(it) }
    }

}
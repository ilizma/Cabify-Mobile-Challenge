package com.ilizma.checkout.flow.navigator

import androidx.navigation.NavController
import com.ilizma.checkout.flow.model.ArticlesArgs
import com.ilizma.marketplace.view.fragment.MarketplaceScreenFragmentDirections

class CheckoutNavigatorImp(
    private val navController: () -> NavController,
) : CheckoutNavigator {

    override fun navigate(
        args: ArticlesArgs,
    ) {
        MarketplaceScreenFragmentDirections.goFromMarketplaceToCheckout(args)
            .let { navController().navigate(it) }
    }

}
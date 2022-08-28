package com.ilizma.marketplace.presentation.model

sealed class MarketplaceNavigationAction {

    data class Checkout(
        val articlesCheckoutInfo: ArticlesCheckoutInfo,
    ) : MarketplaceNavigationAction()

    object Back : MarketplaceNavigationAction()

}

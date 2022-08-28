package com.ilizma.checkout.flow.navigator

import androidx.navigation.NavController

class BackNavigatorImp(
    private val navController: () -> NavController,
) : BackNavigator {

    override fun navigate() {
        navController().popBackStack()
    }

}
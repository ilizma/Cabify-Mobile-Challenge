package com.ilizma.checkout.flow.navigator

import com.ilizma.checkout.flow.model.ArticlesArgs

interface CheckoutNavigator {

    fun navigate(args: ArticlesArgs)

}
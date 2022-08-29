package com.ilizma.checkout.flow.navigator

import com.ilizma.checkout.flow.model.ArticlesInfoArgs

interface CheckoutNavigator {

    fun navigate(args: ArticlesInfoArgs)

}
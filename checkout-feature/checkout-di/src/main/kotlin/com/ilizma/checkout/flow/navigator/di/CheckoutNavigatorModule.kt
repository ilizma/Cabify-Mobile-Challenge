package com.ilizma.checkout.flow.navigator.di

import com.ilizma.checkout.flow.navigator.CheckoutNavigator
import com.ilizma.checkout.flow.navigator.CheckoutNavigatorImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object CheckoutNavigatorModule {

    @Provides
    fun provideWinnerNavigator(
        //fragment: Fragment,
    ): CheckoutNavigator = CheckoutNavigatorImp(
        //navController = { fragment.findNavController() },
    )

}
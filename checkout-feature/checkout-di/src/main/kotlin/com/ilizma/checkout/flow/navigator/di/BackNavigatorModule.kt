package com.ilizma.checkout.flow.navigator.di

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.ilizma.checkout.flow.navigator.BackNavigator
import com.ilizma.checkout.flow.navigator.BackNavigatorImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object BackNavigatorModule {

    @Provides
    fun provideBackNavigator(
        fragment: Fragment,
    ): BackNavigator = BackNavigatorImp(
        navController = { fragment.findNavController() },
    )

}
package com.ilizma.marketplace.flow.navigator.di

import android.app.Activity
import com.ilizma.marketplace.flow.navigator.BackNavigator
import com.ilizma.marketplace.flow.navigator.BackNavigatorImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object BackNavigatorModule {

    @Provides
    fun provideBackNavigator(
        activity: Activity,
    ): BackNavigator = BackNavigatorImp(
        activity = activity,
    )

}
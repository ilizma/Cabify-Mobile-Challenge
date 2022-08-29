package com.ilizma.checkout.view.viewholder.factory.di

import com.ilizma.checkout.view.viewholder.factory.CheckoutItemViewHolderFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object CheckoutItemViewHolderFactoryModule {

    @Provides
    fun provideCheckoutItemViewHolderFactory(
    ): CheckoutItemViewHolderFactory = CheckoutItemViewHolderFactory()

}
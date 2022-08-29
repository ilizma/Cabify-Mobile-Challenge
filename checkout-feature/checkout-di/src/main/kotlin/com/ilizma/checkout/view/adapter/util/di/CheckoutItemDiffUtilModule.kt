package com.ilizma.checkout.view.adapter.util.di

import com.ilizma.checkout.presentation.model.CheckoutInfo
import com.ilizma.checkout.view.adapter.util.CheckoutItemDiffUtilImp
import com.ilizma.view.adapter.util.ItemDiffUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object CheckoutItemDiffUtilModule {

    @Provides
    fun provideCheckoutItemDiffUtil(
    ): ItemDiffUtil<CheckoutInfo> = CheckoutItemDiffUtilImp()

}
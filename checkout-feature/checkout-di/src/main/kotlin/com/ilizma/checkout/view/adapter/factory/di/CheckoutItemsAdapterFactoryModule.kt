package com.ilizma.checkout.view.adapter.factory.di

import com.ilizma.checkout.presentation.model.CheckoutInfo
import com.ilizma.checkout.view.adapter.factory.CheckoutItemsAdapterFactoryImp
import com.ilizma.checkout.view.viewholder.factory.CheckoutItemViewHolderFactory
import com.ilizma.view.adapter.factory.AdapterFactory
import com.ilizma.view.adapter.util.ItemDiffUtil
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object CheckoutItemsAdapterFactoryModule {

    @Provides
    fun provideCheckoutItemsAdapterFactory(
        diffUtil: ItemDiffUtil<CheckoutInfo>,
        viewHolderFactory: CheckoutItemViewHolderFactory,
    ): AdapterFactory<CheckoutInfo> = CheckoutItemsAdapterFactoryImp(
        diffUtil = diffUtil,
        viewHolderFactory = viewHolderFactory,
    )

}
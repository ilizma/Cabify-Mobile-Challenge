package com.ilizma.marketplace.view.binder.di

import com.ilizma.marketplace.view.bind.MarketplaceScreenFragmentBinder
import com.ilizma.marketplace.view.bind.MarketplaceScreenFragmentBinderImp
import com.ilizma.marketplace.view.bind.di.MarketplaceScreenFragmentBinderModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import io.mockk.mockk

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [MarketplaceScreenFragmentBinderModule::class],
)
object MarketplaceScreenFragmentBinderModuleTest {

    @Provides
    fun provideMarketplaceScreenFragmentBinder(
    ): MarketplaceScreenFragmentBinder = mockk<MarketplaceScreenFragmentBinderImp>(relaxed = true)

}
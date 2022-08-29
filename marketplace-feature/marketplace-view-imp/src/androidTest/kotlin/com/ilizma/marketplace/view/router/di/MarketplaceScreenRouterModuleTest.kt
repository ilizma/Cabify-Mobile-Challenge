package com.ilizma.marketplace.view.router.di

import com.ilizma.marketplace.flow.router.MarketplaceScreenRouterImp
import com.ilizma.marketplace.view.router.MarketplaceScreenRouter
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import io.mockk.mockk

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [MarketplaceScreenRouterModule::class],
)
object MarketplaceScreenRouterModuleTest {

    @Provides
    fun provideMarketplaceScreenFragmentBinder(
    ): MarketplaceScreenRouter = mockk<MarketplaceScreenRouterImp>(relaxed = true)

}
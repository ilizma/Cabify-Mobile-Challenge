package com.ilizma.checkout.view.router.di

import com.ilizma.checkout.flow.router.CheckoutScreenRouterImp
import com.ilizma.checkout.view.router.CheckoutScreenRouter
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import io.mockk.mockk

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [CheckoutScreenRouterModule::class],
)
object CheckoutScreenRouterModuleTest {

    @Provides
    fun provideCheckoutScreenFragmentBinder(
    ): CheckoutScreenRouter = mockk<CheckoutScreenRouterImp>(relaxed = true)

}
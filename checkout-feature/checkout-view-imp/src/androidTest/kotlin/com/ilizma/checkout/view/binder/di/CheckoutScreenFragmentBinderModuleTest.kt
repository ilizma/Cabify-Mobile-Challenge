package com.ilizma.checkout.view.binder.di

import com.ilizma.checkout.view.bind.CheckoutScreenFragmentBinder
import com.ilizma.checkout.view.bind.CheckoutScreenFragmentBinderImp
import com.ilizma.checkout.view.bind.di.CheckoutScreenFragmentBinderModule
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import io.mockk.mockk

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [CheckoutScreenFragmentBinderModule::class],
)
object CheckoutScreenFragmentBinderModuleTest {

    @Provides
    fun provideCheckoutScreenFragmentBinder(
    ): CheckoutScreenFragmentBinder = mockk<CheckoutScreenFragmentBinderImp>(relaxed = true)

}
package com.ilizma.checkout.view.fragment

import com.ilizma.androidtest.launchFragmentInHiltContainer
import com.ilizma.checkout.flow.router.CheckoutScreenRouterImp
import com.ilizma.checkout.view.bind.CheckoutScreenFragmentBinder
import com.ilizma.checkout.view.bind.CheckoutScreenFragmentBinderImp
import com.ilizma.checkout.view.bind.di.CheckoutScreenFragmentBinderModule
import com.ilizma.checkout.view.router.CheckoutScreenRouter
import com.ilizma.checkout.view.router.di.CheckoutScreenRouterModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import dagger.hilt.components.SingletonComponent
import io.mockk.MockKAnnotations
import io.mockk.mockk
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@UninstallModules(
    CheckoutScreenFragmentBinderModule::class,
)
@HiltAndroidTest
class CheckoutScreenFragmentAndroidTest {

    @Module
    @InstallIn(SingletonComponent::class)
    object CheckoutScreenFragmentBinderModuleTest {

        @Provides
        fun provideCheckoutScreenFragmentBinder(
        ): CheckoutScreenFragmentBinder = mockk<CheckoutScreenFragmentBinderImp>(relaxed = true)

    }

    @get:Rule
    var hiltAndroidRule = HiltAndroidRule(this)

    private lateinit var fragment: CheckoutScreenFragment

    init {
        MockKAnnotations.init(this)
    }

    @Before
    fun setup() {
        hiltAndroidRule.inject()
        launchFragmentInHiltContainer<CheckoutScreenFragment> {
            fragment = this
        }
    }

    @Test
    fun test() {
        verify { fragment.router.init() }
        verify { fragment.binder.bind(any()) }
    }

}
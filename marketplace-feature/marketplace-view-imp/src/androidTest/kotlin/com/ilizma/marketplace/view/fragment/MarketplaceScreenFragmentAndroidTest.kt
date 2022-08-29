package com.ilizma.marketplace.view.fragment

import com.ilizma.androidtest.launchFragmentInHiltContainer
import com.ilizma.marketplace.view.bind.MarketplaceScreenFragmentBinder
import com.ilizma.marketplace.view.bind.MarketplaceScreenFragmentBinderImp
import com.ilizma.marketplace.view.bind.di.MarketplaceScreenFragmentBinderModule
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
    MarketplaceScreenFragmentBinderModule::class,
)
@HiltAndroidTest
internal class MarketplaceScreenFragmentAndroidTest {

    @Module
    @InstallIn(SingletonComponent::class)
    object MarketplaceScreenFragmentBinderModuleTest {

        @Provides
        fun provideMarketplaceScreenFragmentBinder(
        ): MarketplaceScreenFragmentBinder =
            mockk<MarketplaceScreenFragmentBinderImp>(relaxed = true)

    }

    @get:Rule
    var hiltAndroidRule = HiltAndroidRule(this)

    private lateinit var fragment: MarketplaceScreenFragment

    init {
        MockKAnnotations.init(this)
    }

    @Before
    fun setup() {
        hiltAndroidRule.inject()
        launchFragmentInHiltContainer<MarketplaceScreenFragment> {
            fragment = this
        }
    }

    @Test
    fun test() {
        verify { fragment.router.init() }
        verify { fragment.binder.bind(any()) }
    }

}
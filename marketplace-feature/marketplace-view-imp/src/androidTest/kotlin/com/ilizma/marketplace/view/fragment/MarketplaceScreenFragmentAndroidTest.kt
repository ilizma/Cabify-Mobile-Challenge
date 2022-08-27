package com.ilizma.marketplace.view.fragment

import com.ilizma.androidtest.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.MockKAnnotations
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
internal class MarketplaceScreenFragmentAndroidTest {

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
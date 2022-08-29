package com.ilizma.checkout.view.fragment

import com.ilizma.androidtest.launchFragmentInHiltContainer
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.MockKAnnotations
import io.mockk.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class CheckoutScreenFragmentAndroidTest {

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
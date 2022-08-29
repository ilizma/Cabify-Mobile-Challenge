package com.ilizma.marketplace.view.bind

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.ilizma.androidtest.launchFragmentInHiltContainer
import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.presentation.model.ArticlesState
import com.ilizma.marketplace.presentation.model.CheckoutState
import com.ilizma.marketplace.presentation.viewmodel.MarketplaceViewModel
import com.ilizma.marketplace.view.R
import com.ilizma.marketplace.view.bind.di.MarketplaceScreenFragmentBinderModule
import com.ilizma.marketplace.view.fragment.MarketplaceScreenFragment
import com.ilizma.view.adapter.factory.AdapterFactory
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@UninstallModules(
    MarketplaceScreenFragmentBinderModule::class,
)
@HiltAndroidTest
internal class MarketplaceScreenFragmentBinderImpAndroidTest {

    @get:Rule
    var hiltAndroidRule = HiltAndroidRule(this)

    @RelaxedMockK
    private lateinit var _state: MutableLiveData<ArticlesState>

    @RelaxedMockK
    private lateinit var _error: MutableLiveData<String>

    @RelaxedMockK
    private lateinit var _checkoutState: MutableLiveData<CheckoutState>

    @RelaxedMockK
    private lateinit var viewModelLazy: Lazy<MarketplaceViewModel>

    @RelaxedMockK
    private lateinit var viewModel: MarketplaceViewModel

    @RelaxedMockK
    private lateinit var adapterFactory: AdapterFactory<Article>

    @RelaxedMockK
    private lateinit var lifecycleOwner: LifecycleOwner

    @BindValue
    @RelaxedMockK
    lateinit var binder: MarketplaceScreenFragmentBinder

    init {
        MockKAnnotations.init(this)
        every { viewModelLazy.value } returns viewModel
    }

    @Before
    fun setup() {
        hiltAndroidRule.inject()
        launchFragmentInHiltContainer<MarketplaceScreenFragment>()
        binder = MarketplaceScreenFragmentBinderImp(
            viewModelLazy = viewModelLazy,
            adapterFactory = adapterFactory,
            lifecycleOwner = { lifecycleOwner },
        )
    }

    @Test
    fun test() {
        marketplaceScreenBCheckoutClickTest()
        stateTest()
        errorTest()
        checkoutStateTest()
    }

    private fun marketplaceScreenBCheckoutClickTest() {
        // when
        onView(withId(R.id.marketplace_screen_b_checkout)).perform(click())

        // then
        verify { viewModel.onCheckout() }
    }

    private fun stateTest() {
        // given
        val articlesState = mockk<ArticlesState>()
        every { viewModel.state } returns _state
        every { _state.value } returns articlesState

        // then
        assertEquals(viewModel.state.value, articlesState)
    }

    private fun errorTest() {
        // given
        val errorMessage = "errorMessage"
        every { viewModel.error } returns _error
        every { _error.value } returns errorMessage

        // then
        assertEquals(viewModel.error.value, errorMessage)
    }

    private fun checkoutStateTest() {
        // given
        val checkoutState = mockk<CheckoutState>()
        every { viewModel.checkoutState } returns _checkoutState
        every { _checkoutState.value } returns checkoutState

        // then
        assertEquals(viewModel.checkoutState.value, checkoutState)
    }

}
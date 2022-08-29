package com.ilizma.checkout.view.bind

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import com.ilizma.androidtest.launchFragmentInHiltContainer
import com.ilizma.checkout.presentation.model.CheckoutInfo
import com.ilizma.checkout.presentation.model.CheckoutInfoList
import com.ilizma.checkout.presentation.viewmodel.CheckoutViewModel
import com.ilizma.checkout.view.fragment.CheckoutScreenFragment
import com.ilizma.view.adapter.factory.AdapterFactory
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
internal class CheckoutScreenFragmentBinderImpAndroidTest {

    @get:Rule
    var hiltAndroidRule = HiltAndroidRule(this)

    @RelaxedMockK
    private lateinit var _list: MutableLiveData<CheckoutInfoList>

    @RelaxedMockK
    private lateinit var _total: MutableLiveData<String>

    @RelaxedMockK
    private lateinit var viewModelLazy: Lazy<CheckoutViewModel>

    @RelaxedMockK
    private lateinit var viewModel: CheckoutViewModel

    @RelaxedMockK
    private lateinit var adapterFactory: AdapterFactory<CheckoutInfo>

    @RelaxedMockK
    private lateinit var lifecycleOwner: LifecycleOwner

    private lateinit var binder: CheckoutScreenFragmentBinder

    init {
        MockKAnnotations.init(this)
        every { viewModelLazy.value } returns viewModel
    }

    @Before
    fun setup() {
        hiltAndroidRule.inject()
        launchFragmentInHiltContainer<CheckoutScreenFragment>()
        binder = CheckoutScreenFragmentBinderImp(
            viewModelLazy = viewModelLazy,
            adapterFactory = adapterFactory,
            lifecycleOwner = { lifecycleOwner },
        )
    }

    @Test
    fun test() {
        listTest()
        totalTest()
    }

    private fun listTest() {
        // given
        val checkoutInfoList = mockk<CheckoutInfoList>()
        every { viewModel.list } returns _list
        every { _list.value } returns checkoutInfoList

        // then
        assertEquals(viewModel.list.value, checkoutInfoList)
    }

    private fun totalTest() {
        // given
        val total = "57€"
        every { viewModel.total } returns _total
        every { _total.value } returns total

        // then
        assertEquals(viewModel.total.value, total)
    }

}
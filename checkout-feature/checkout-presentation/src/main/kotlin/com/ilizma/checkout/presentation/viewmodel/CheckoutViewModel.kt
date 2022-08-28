package com.ilizma.checkout.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ilizma.checkout.presentation.model.CheckoutInfoList
import com.ilizma.checkout.presentation.model.CheckoutNavigationAction

abstract class CheckoutViewModel : ViewModel() {

    abstract val list: LiveData<CheckoutInfoList>

    abstract val navigationAction: LiveData<CheckoutNavigationAction>

    abstract fun onBack()

}
package com.ilizma.checkout.view.bind

import androidx.lifecycle.LifecycleOwner
import com.ilizma.checkout.presentation.model.CheckoutInfoList
import com.ilizma.checkout.presentation.viewmodel.CheckoutViewModel
import com.ilizma.checkout.view.databinding.CheckoutScreenFragmentBinding

class CheckoutScreenFragmentBinderImp(
    viewModelLazy: Lazy<CheckoutViewModel>,
    private val lifecycleOwner: () -> LifecycleOwner,
) : CheckoutScreenFragmentBinder {

    private val viewModel by viewModelLazy
    private lateinit var binding: CheckoutScreenFragmentBinding

    override fun bind(binding: CheckoutScreenFragmentBinding) {
        this.binding = binding
        setListeners()
        setupObservers()
    }

    private fun setListeners() {

    }

    private fun setupObservers() {
        viewModel.list.observe(
            lifecycleOwner(),
            ::onCheckoutInfoList,
        )
    }

    private fun onCheckoutInfoList(
        list: CheckoutInfoList,
    ) {
        // TODO: add RV
    }

}
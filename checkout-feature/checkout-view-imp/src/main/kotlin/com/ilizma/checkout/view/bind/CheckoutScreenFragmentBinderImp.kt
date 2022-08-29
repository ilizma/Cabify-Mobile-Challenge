package com.ilizma.checkout.view.bind

import androidx.lifecycle.LifecycleOwner
import com.ilizma.checkout.presentation.model.CheckoutInfo
import com.ilizma.checkout.presentation.model.CheckoutInfoList
import com.ilizma.checkout.presentation.viewmodel.CheckoutViewModel
import com.ilizma.checkout.view.databinding.CheckoutScreenFragmentBinding
import com.ilizma.view.adapter.Adapter
import com.ilizma.view.adapter.factory.AdapterFactory

class CheckoutScreenFragmentBinderImp(
    viewModelLazy: Lazy<CheckoutViewModel>,
    adapterFactory: AdapterFactory<CheckoutInfo>,
    private val lifecycleOwner: () -> LifecycleOwner,
) : CheckoutScreenFragmentBinder {

    private val viewModel by viewModelLazy
    private val adapter: Adapter<CheckoutInfo> by lazy { adapterFactory.create() }
    private lateinit var binding: CheckoutScreenFragmentBinding

    override fun bind(binding: CheckoutScreenFragmentBinding) {
        this.binding = binding
        setupAdapter()
        setupObservers()
    }

    private fun setupAdapter() {
        binding.checkoutScreenRv.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.list.observe(
            lifecycleOwner(),
            ::onCheckoutInfoList,
        )
        viewModel.total.observe(
            lifecycleOwner(),
            ::onTotal,
        )
    }

    private fun onCheckoutInfoList(
        checkoutInfoList: CheckoutInfoList,
    ) {
        adapter.submitList(checkoutInfoList.list)
    }

    private fun onTotal(
        total: String,
    ) {
        binding.checkoutScreenTvTotal.text = total
    }

}
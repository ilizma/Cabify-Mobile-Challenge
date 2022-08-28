package com.ilizma.checkout.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ilizma.checkout.view.R
import com.ilizma.checkout.view.bind.CheckoutScreenFragmentBinder
import com.ilizma.checkout.view.databinding.CheckoutScreenFragmentBinding
import com.ilizma.checkout.view.router.CheckoutScreenRouter
import com.ilizma.view.binding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CheckoutScreenFragment : Fragment(R.layout.checkout_screen_fragment) {

    @Inject
    internal lateinit var binder: CheckoutScreenFragmentBinder

    @Inject
    internal lateinit var router: CheckoutScreenRouter

    private val binding by viewBinding(CheckoutScreenFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        router.init()
        binder.bind(binding)
    }

}
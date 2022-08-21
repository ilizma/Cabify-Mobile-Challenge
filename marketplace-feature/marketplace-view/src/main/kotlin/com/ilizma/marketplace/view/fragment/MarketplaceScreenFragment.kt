package com.ilizma.marketplace.view.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ilizma.marketplace.view.R
import com.ilizma.marketplace.view.bind.MarketplaceScreenFragmentBinder
import com.ilizma.marketplace.view.databinding.MarketplaceScreenFragmentBinding
import com.ilizma.marketplace.view.router.MarketplaceScreenRouter
import com.ilizma.view.binding.viewBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MarketplaceScreenFragment : Fragment(R.layout.marketplace_screen_fragment) {

    @Inject
    internal lateinit var binder: MarketplaceScreenFragmentBinder

    @Inject
    internal lateinit var router: MarketplaceScreenRouter

    private val binding by viewBinding(MarketplaceScreenFragmentBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        router.init()
        binder.bind(binding)
    }

}
package com.ilizma.marketplace.view.bind

import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.lifecycle.LifecycleOwner
import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.presentation.model.ArticlesState
import com.ilizma.marketplace.presentation.model.CheckoutState
import com.ilizma.marketplace.presentation.viewmodel.MarketplaceViewModel
import com.ilizma.marketplace.view.adapter.ArticlesAdapter
import com.ilizma.marketplace.view.adapter.factory.ArticlesAdapterFactory
import com.ilizma.marketplace.view.databinding.MarketplaceScreenFragmentBinding
import com.ilizma.resources.R
import com.ilizma.view.extensions.setOnReactiveClickListener
import com.ilizma.view.extensions.snackbar

class MarketplaceScreenFragmentBinderImp(
    viewModelLazy: Lazy<MarketplaceViewModel>,
    adapterFactory: ArticlesAdapterFactory<Article>,
    private val lifecycleOwner: () -> LifecycleOwner,
) : MarketplaceScreenFragmentBinder {

    private val viewModel by viewModelLazy
    private val adapter: ArticlesAdapter<Article> by lazy { adapterFactory.create() }
    private lateinit var binding: MarketplaceScreenFragmentBinding

    override fun bind(binding: MarketplaceScreenFragmentBinding) {
        this.binding = binding
        setupListener()
        setupAdapter()
        setupObservers()
    }

    private fun setupListener() {
        binding.marketplaceScreenBCheckout.setOnReactiveClickListener { viewModel.onCheckout() }
    }

    private fun setupAdapter() {
        binding.marketplaceScreenRv.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.state.observe(
            lifecycleOwner(),
            ::onArticlesState,
        )
        viewModel.error.observe(
            lifecycleOwner(),
            ::onError,
        )
        viewModel.checkoutState.observe(
            lifecycleOwner(),
            ::onCheckoutState,
        )
    }

    private fun onArticlesState(
        state: ArticlesState,
    ) {
        adapter.submitList(state.list)
    }

    private fun onError(
        errorMessage: String,
    ) {
        binding.root.snackbar(
            title = errorMessage,
            action = binding.root.context.getString(R.string.retry)
        ) { viewModel.getState() }
    }

    private fun onCheckoutState(
        state: CheckoutState,
    ) {
        binding.marketplaceScreenBCheckout.isInvisible = state == CheckoutState.LOADING
        binding.marketplaceScreenPbCheckout.isVisible = state == CheckoutState.LOADING
    }

}
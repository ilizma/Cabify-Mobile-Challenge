package com.ilizma.marketplace.view.router.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ilizma.marketplace.flow.router.MarketplaceScreenRouterImp
import com.ilizma.marketplace.presentation.viewmodel.factory.di.MARKETPLACE_VIEW_MODEL_PROVIDER_NAMED
import com.ilizma.marketplace.view.router.MarketplaceScreenRouter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
object MarketplaceScreenRouterModule {

    @Provides
    fun provideMarketplaceScreenRouter(
        fragment: Fragment,
        @Named(MARKETPLACE_VIEW_MODEL_PROVIDER_NAMED) viewModelProviderFactory: ViewModelProvider.Factory,
    ): MarketplaceScreenRouter = MarketplaceScreenRouterImp(
        lifecycleOwner = { fragment.viewLifecycleOwner },
        onBackPressedDispatcher = fragment.requireActivity().onBackPressedDispatcher,
        viewModelLazy = fragment.viewModels { viewModelProviderFactory },
        //navigator = checkoutNavigator,
    )

}
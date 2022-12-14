package com.ilizma.marketplace.view.router.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ilizma.checkout.flow.navigator.CheckoutNavigator
import com.ilizma.marketplace.flow.mapper.ArticleInfoArgsMapper
import com.ilizma.marketplace.flow.mapper.ArticlesInfoArgsMapper
import com.ilizma.marketplace.flow.navigator.BackNavigator
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
        checkoutNavigator: CheckoutNavigator,
        backNavigator: BackNavigator,
        @Named(MARKETPLACE_VIEW_MODEL_PROVIDER_NAMED) viewModelProviderFactory: ViewModelProvider.Factory,
    ): MarketplaceScreenRouter = MarketplaceScreenRouterImp(
        lifecycleOwner = { fragment.viewLifecycleOwner },
        onBackPressedDispatcher = fragment.requireActivity().onBackPressedDispatcher,
        viewModelLazy = fragment.viewModels { viewModelProviderFactory },
        checkoutNavigator = checkoutNavigator,
        backNavigator = backNavigator,
        mapper = ArticlesInfoArgsMapper(
            mapper = ArticleInfoArgsMapper(),
        ),
    )

}
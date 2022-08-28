package com.ilizma.checkout.view.router.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ilizma.checkout.flow.navigator.BackNavigator
import com.ilizma.checkout.flow.router.CheckoutScreenRouterImp
import com.ilizma.checkout.presentation.viewmodel.factory.di.CHECKOUT_VIEW_MODEL_PROVIDER_NAMED
import com.ilizma.checkout.view.router.CheckoutScreenRouter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
object CheckoutScreenRouterModule {

    @Provides
    fun provideCheckoutScreenRouter(
        fragment: Fragment,
        navigator: BackNavigator,
        @Named(CHECKOUT_VIEW_MODEL_PROVIDER_NAMED) viewModelProviderFactory: ViewModelProvider.Factory,
    ): CheckoutScreenRouter = CheckoutScreenRouterImp(
        lifecycleOwner = { fragment.viewLifecycleOwner },
        onBackPressedDispatcher = fragment.requireActivity().onBackPressedDispatcher,
        viewModelLazy = fragment.viewModels { viewModelProviderFactory },
        navigator = navigator,
    )

}
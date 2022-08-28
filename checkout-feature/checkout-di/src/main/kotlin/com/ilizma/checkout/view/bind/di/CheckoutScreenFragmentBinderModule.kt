package com.ilizma.checkout.view.bind.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ilizma.checkout.presentation.model.CheckoutInfo
import com.ilizma.checkout.presentation.viewmodel.factory.di.CHECKOUT_VIEW_MODEL_PROVIDER_NAMED
import com.ilizma.checkout.view.bind.CheckoutScreenFragmentBinder
import com.ilizma.checkout.view.bind.CheckoutScreenFragmentBinderImp
import com.ilizma.view.adapter.factory.AdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
object CheckoutScreenFragmentBinderModule {

    @Provides
    fun provideCheckoutScreenFragmentBinder(
        fragment: Fragment,
        adapterFactory: AdapterFactory<CheckoutInfo>,
        @Named(CHECKOUT_VIEW_MODEL_PROVIDER_NAMED) viewModelProviderFactory: ViewModelProvider.Factory,
    ): CheckoutScreenFragmentBinder = CheckoutScreenFragmentBinderImp(
        viewModelLazy = fragment.viewModels { viewModelProviderFactory },
        adapterFactory = adapterFactory,
        lifecycleOwner = { fragment.viewLifecycleOwner },
    )

}
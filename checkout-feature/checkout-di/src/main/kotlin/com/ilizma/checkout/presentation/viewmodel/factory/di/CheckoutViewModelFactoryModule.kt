package com.ilizma.checkout.presentation.viewmodel.factory.di

import androidx.lifecycle.ViewModelProvider
import com.ilizma.checkout.presentation.viewmodel.factory.CheckoutViewModelAssistedFactory
import com.ilizma.checkout.presentation.viewmodel.factory.CheckoutViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

const val CHECKOUT_VIEW_MODEL_PROVIDER_NAMED = "CHECKOUT_VIEW_MODEL_PROVIDER_NAMED"

@Module
@InstallIn(FragmentComponent::class)
object CheckoutViewModelFactoryModule {

    @Provides
    @Named(CHECKOUT_VIEW_MODEL_PROVIDER_NAMED)
    fun provideCheckoutViewModelFactory(
        viewModelAssistedFactory: CheckoutViewModelAssistedFactory,
    ): ViewModelProvider.Factory = CheckoutViewModelFactory(
        viewModelAssistedFactory,
    )

}
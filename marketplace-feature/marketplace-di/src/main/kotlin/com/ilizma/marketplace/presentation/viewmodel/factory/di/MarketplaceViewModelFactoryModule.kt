package com.ilizma.marketplace.presentation.viewmodel.factory.di

import androidx.lifecycle.ViewModelProvider
import com.ilizma.marketplace.presentation.viewmodel.factory.MarketplaceViewModelAssistedFactory
import com.ilizma.marketplace.presentation.viewmodel.factory.MarketplaceViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

const val MARKETPLACE_VIEW_MODEL_PROVIDER_NAMED = "MARKETPLACE_VIEW_MODEL_PROVIDER_NAMED"

@Module
@InstallIn(FragmentComponent::class)
object MarketplaceViewModelFactoryModule {

    @Provides
    @Named(MARKETPLACE_VIEW_MODEL_PROVIDER_NAMED)
    fun provideMarketplaceViewModelFactory(
        viewModelAssistedFactory: MarketplaceViewModelAssistedFactory,
    ): ViewModelProvider.Factory = MarketplaceViewModelFactory(
        viewModelAssistedFactory,
    )

}
package com.ilizma.marketplace.view.bind.di

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.presentation.viewmodel.factory.di.MARKETPLACE_VIEW_MODEL_PROVIDER_NAMED
import com.ilizma.marketplace.view.adapter.factory.ArticlesAdapterFactory
import com.ilizma.marketplace.view.bind.MarketplaceScreenFragmentBinder
import com.ilizma.marketplace.view.bind.MarketplaceScreenFragmentBinderImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
object MarketplaceScreenFragmentBinderModule {

    @Provides
    fun provideMarketplaceScreenFragmentBinder(
        @ApplicationContext context: Context,
        fragment: Fragment,
        adapterFactory: ArticlesAdapterFactory<Article>,
        @Named(MARKETPLACE_VIEW_MODEL_PROVIDER_NAMED) viewModelProviderFactory: ViewModelProvider.Factory,
    ): MarketplaceScreenFragmentBinder = MarketplaceScreenFragmentBinderImp(
        viewModelLazy = fragment.viewModels { viewModelProviderFactory },
        adapterFactory = adapterFactory,
        lifecycleOwner = { fragment.viewLifecycleOwner },
    )

}
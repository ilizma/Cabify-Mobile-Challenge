package com.ilizma.marketplace.view.bind.factory.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ilizma.marketplace.presentation.viewmodel.factory.di.MARKETPLACE_VIEW_MODEL_PROVIDER_NAMED
import com.ilizma.marketplace.view.bind.factory.ArticleBinderFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
object ArticleBinderFactoryModule {

    @Provides
    fun provideArticleBinderFactory(
        fragment: Fragment,
        @Named(MARKETPLACE_VIEW_MODEL_PROVIDER_NAMED) viewModelProviderFactory: ViewModelProvider.Factory,
    ): ArticleBinderFactory = ArticleBinderFactory(
        viewModelLazy = fragment.viewModels { viewModelProviderFactory },
        lifecycleOwner = { fragment.viewLifecycleOwner },
    )

}
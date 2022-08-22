package com.ilizma.marketplace.view.bind.factory.di

import androidx.fragment.app.Fragment
import com.ilizma.marketplace.presentation.viewmodel.factory.ArticleViewModelAssistedFactory
import com.ilizma.marketplace.view.bind.factory.ArticleBinderFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ArticleBinderFactoryModule {

    @Provides
    fun provideArticleBinderFactory(
        fragment: Fragment,
        viewModelAssistedFactory: ArticleViewModelAssistedFactory,
    ): ArticleBinderFactory = ArticleBinderFactory(
        viewModelAssistedFactory = viewModelAssistedFactory,
        lifecycleOwner = { fragment.viewLifecycleOwner },
    )

}
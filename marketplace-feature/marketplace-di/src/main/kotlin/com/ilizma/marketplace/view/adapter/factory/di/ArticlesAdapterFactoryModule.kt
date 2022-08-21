package com.ilizma.marketplace.view.adapter.factory.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.presentation.viewmodel.factory.di.MARKETPLACE_VIEW_MODEL_PROVIDER_NAMED
import com.ilizma.marketplace.view.adapter.factory.ArticlesAdapterFactory
import com.ilizma.marketplace.view.adapter.factory.ArticlesAdapterFactoryImp
import com.ilizma.marketplace.view.adapter.util.ArticleItemDiffUtil
import com.ilizma.marketplace.view.bind.factory.ArticleBinderFactory
import com.ilizma.marketplace.view.viewholder.factory.ArticleViewHolderFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import javax.inject.Named

@Module
@InstallIn(FragmentComponent::class)
object ArticlesAdapterFactoryModule {

    @Provides
    fun provideArticlesAdapterFactory(
        fragment: Fragment,
        binderFactory: ArticleBinderFactory,
        diffUtil: ArticleItemDiffUtil<Article>,
        viewHolderFactory: ArticleViewHolderFactory,
        @Named(MARKETPLACE_VIEW_MODEL_PROVIDER_NAMED) viewModelProviderFactory: ViewModelProvider.Factory,
    ): ArticlesAdapterFactory<Article> = ArticlesAdapterFactoryImp(
        binderFactory = binderFactory,
        diffUtil = diffUtil,
        viewHolderFactory = viewHolderFactory,
        viewModelLazy = fragment.viewModels { viewModelProviderFactory }
    )

}
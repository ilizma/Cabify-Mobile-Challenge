package com.ilizma.marketplace.view.adapter.factory.di

import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.view.adapter.factory.ArticlesAdapterFactory
import com.ilizma.marketplace.view.adapter.factory.ArticlesAdapterFactoryImp
import com.ilizma.marketplace.view.adapter.util.ArticleItemDiffUtil
import com.ilizma.marketplace.view.bind.factory.ArticleBinderFactory
import com.ilizma.marketplace.view.viewholder.factory.ArticleViewHolderFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ArticlesAdapterFactoryModule {

    @Provides
    fun provideArticlesAdapterFactory(
        binderFactory: ArticleBinderFactory,
        diffUtil: ArticleItemDiffUtil<Article>,
        viewHolderFactory: ArticleViewHolderFactory,
    ): ArticlesAdapterFactory<Article> = ArticlesAdapterFactoryImp(
        binderFactory = binderFactory,
        diffUtil = diffUtil,
        viewHolderFactory = viewHolderFactory,
    )

}
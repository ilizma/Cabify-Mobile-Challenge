package com.ilizma.marketplace.view.adapter.factory.di

import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.view.bind.factory.ArticleBinderFactory
import com.ilizma.marketplace.view.viewholder.factory.ArticleViewHolderFactory
import com.ilizma.view.adapter.factory.AdapterFactory
import com.ilizma.marketplace.view.adapter.factory.ArticlesAdapterFactoryImp
import com.ilizma.view.adapter.util.ItemDiffUtil
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
        diffUtil: ItemDiffUtil<Article>,
        viewHolderFactory: ArticleViewHolderFactory,
    ): AdapterFactory<Article> = ArticlesAdapterFactoryImp(
        binderFactory = binderFactory,
        diffUtil = diffUtil,
        viewHolderFactory = viewHolderFactory,
    )

}
package com.ilizma.marketplace.view.viewholder.factory.di

import com.ilizma.marketplace.view.viewholder.factory.ArticleViewHolderFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ArticleViewHolderFactoryModule {

    @Provides
    fun provideArticleViewHolderFactory(
    ): ArticleViewHolderFactory = ArticleViewHolderFactory()

}
package com.ilizma.marketplace.view.adapter.util.di

import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.view.adapter.util.ItemDiffUtil
import com.ilizma.marketplace.view.adapter.util.ArticleItemDiffUtilImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ArticleItemDiffUtilModule {

    @Provides
    fun provideArticleItemDiffUtil(
    ): ItemDiffUtil<Article> = ArticleItemDiffUtilImp()

}
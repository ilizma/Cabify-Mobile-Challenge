package com.ilizma.marketplace.domain.repository.di

import com.ilizma.marketplace.data.cache.ProductQuantityCache
import com.ilizma.marketplace.data.repository.ArticleRepositoryImp
import com.ilizma.marketplace.domain.repository.ArticleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ArticleRepositoryModule {

    @Provides
    fun provideArticleRepository(
        cache: ProductQuantityCache,
    ): ArticleRepository = ArticleRepositoryImp(
        cache = cache,
    )

}
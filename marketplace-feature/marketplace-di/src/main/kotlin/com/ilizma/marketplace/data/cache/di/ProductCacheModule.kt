package com.ilizma.marketplace.data.cache.di

import com.ilizma.marketplace.data.cache.ProductCache
import com.ilizma.marketplace.data.cache.ProductCacheImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ProductCacheModule {

    @Provides
    fun provideProductCache(
    ): ProductCache = ProductCacheImp(
        cache = null,
    )

}
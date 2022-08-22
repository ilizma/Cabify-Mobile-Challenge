package com.ilizma.marketplace.data.cache.di

import com.ilizma.marketplace.data.cache.ProductCache
import com.ilizma.marketplace.data.cache.ProductCacheImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductCacheModule {

    @Provides
    @Singleton
    fun provideProductCache(
    ): ProductCache = ProductCacheImp(
        cacheMap = hashMapOf(),
    )

}
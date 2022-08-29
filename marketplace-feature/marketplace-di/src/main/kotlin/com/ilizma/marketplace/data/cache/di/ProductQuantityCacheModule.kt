package com.ilizma.marketplace.data.cache.di

import com.ilizma.marketplace.data.cache.ProductQuantityCache
import com.ilizma.marketplace.data.cache.ProductQuantityCacheImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductQuantityCacheModule {

    @Provides
    @Singleton
    fun provideProductCache(
    ): ProductQuantityCache = ProductQuantityCacheImp(
        cacheMap = hashMapOf(),
    )

}
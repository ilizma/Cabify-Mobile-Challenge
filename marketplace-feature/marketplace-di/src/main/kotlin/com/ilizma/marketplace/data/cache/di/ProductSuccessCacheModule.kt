package com.ilizma.marketplace.data.cache.di

import com.ilizma.marketplace.data.cache.ProductSuccessCache
import com.ilizma.marketplace.data.cache.ProductSuccessCacheImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductSuccessCacheModule {

    @Provides
    @Singleton
    fun provideProductSuccessCache(
    ): ProductSuccessCache = ProductSuccessCacheImp(
        cache = null,
    )

}
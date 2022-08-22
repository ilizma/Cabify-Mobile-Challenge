package com.ilizma.marketplace.data.cache.di

import com.ilizma.marketplace.data.cache.ProductSuccessCache
import com.ilizma.marketplace.data.cache.ProductSuccessCacheImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object ProductSuccessCacheModule {

    @Provides
    fun provideProductSuccessCache(
    ): ProductSuccessCache = ProductSuccessCacheImp(
        cache = null,
    )

}
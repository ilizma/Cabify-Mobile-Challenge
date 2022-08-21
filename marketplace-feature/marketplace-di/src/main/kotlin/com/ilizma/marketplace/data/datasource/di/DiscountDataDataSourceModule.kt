package com.ilizma.marketplace.data.datasource.di

import com.ilizma.marketplace.data.datasource.DiscountDataDataSource
import com.ilizma.marketplace.data.datasource.DiscountDataDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object DiscountDataDataSourceModule {

    @Provides
    fun provideDiscountDataDataSource(
    ): DiscountDataDataSource = DiscountDataDataSourceImp()

}
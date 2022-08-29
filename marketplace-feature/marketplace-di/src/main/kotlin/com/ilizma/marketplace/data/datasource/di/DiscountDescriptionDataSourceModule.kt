package com.ilizma.marketplace.data.datasource.di

import android.content.Context
import com.ilizma.marketplace.data.datasource.DiscountDescriptionDataSource
import com.ilizma.marketplace.data.datasource.DiscountDescriptionDataSourceImp
import com.ilizma.resources.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(FragmentComponent::class)
object DiscountDescriptionDataSourceModule {

    @Provides
    fun provideDiscountDescriptionDataSource(
        @ApplicationContext context: Context,
    ): DiscountDescriptionDataSource = DiscountDescriptionDataSourceImp(
        promotionText = context.getString(R.string.promotion_description),
        bulkText = context.getString(R.string.bulk_description),
    )

}
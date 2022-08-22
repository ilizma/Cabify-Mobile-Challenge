package com.ilizma.marketplace.data.datasource.di

import android.content.Context
import com.ilizma.api.data.Api
import com.ilizma.marketplace.data.datasource.ProductDataSource
import com.ilizma.marketplace.data.datasource.ProductDataSourceImp
import com.ilizma.marketplace.data.mapper.ProductMapper
import com.ilizma.marketplace.data.mapper.ProductsStateMapper
import com.ilizma.resources.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.*

@Module
@InstallIn(FragmentComponent::class)
object ProductDataSourceModule {

    @Provides
    fun provideProductDataSource(
        @ApplicationContext context: Context,
        api: Api,
    ): ProductDataSource = ProductDataSourceImp(
        api = api,
        mapper = ProductsStateMapper(
            mapper = ProductMapper(
                Locale.getDefault(),
                moneyText = context.getString(R.string.money_symbol),
            ),
            unknownErrorMessage = context.getString(R.string.unknown_error),
        ),
    )

}
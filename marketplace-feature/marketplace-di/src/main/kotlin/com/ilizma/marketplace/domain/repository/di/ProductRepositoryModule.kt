package com.ilizma.marketplace.domain.repository.di

import android.content.Context
import com.ilizma.marketplace.data.cache.ProductSuccessCache
import com.ilizma.marketplace.data.datasource.ProductDataSource
import com.ilizma.marketplace.data.mapper.ProductMapper
import com.ilizma.marketplace.data.mapper.ProductsMapper
import com.ilizma.marketplace.data.mapper.ProductsStateMapper
import com.ilizma.marketplace.data.repository.ProductRepositoryImp
import com.ilizma.marketplace.domain.repository.ProductRepository
import com.ilizma.resources.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.*

@Module
@InstallIn(FragmentComponent::class)
object ProductRepositoryModule {

    @Provides
    fun provideProductRepository(
        @ApplicationContext context: Context,
        dataSource: ProductDataSource,
        cache: ProductSuccessCache,
    ): ProductRepository = ProductRepositoryImp(
        dataSource = dataSource,
        cache = cache,
        productsStateMapper = ProductsStateMapper(
            mapper = ProductMapper(
                locale = Locale.getDefault(),
                moneyText = context.getString(R.string.money_symbol),
            ),
            unknownErrorMessage = context.getString(R.string.unknown_error),
        ),
        productsMapper = ProductsMapper(
            ProductMapper(
                locale = Locale.getDefault(),
                moneyText = context.getString(R.string.money_symbol),
            ),
        ),
    )

}
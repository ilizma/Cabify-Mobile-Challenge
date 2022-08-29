package com.ilizma.checkout.domain.repository.di

import android.content.Context
import com.ilizma.checkout.data.datasource.CheckoutDataSource
import com.ilizma.checkout.data.mapper.CheckoutInfoListMapper
import com.ilizma.checkout.data.mapper.CheckoutInfoMapper
import com.ilizma.checkout.data.repository.CheckoutRepositoryImp
import com.ilizma.checkout.domain.repository.CheckoutRepository
import com.ilizma.resources.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.*

@Module
@InstallIn(FragmentComponent::class)
object CheckoutRepositoryModule {

    @Provides
    fun provideCheckoutRepository(
        @ApplicationContext context: Context,
        dataSource: CheckoutDataSource,
    ): CheckoutRepository = CheckoutRepositoryImp(
        dataSource = dataSource,
        mapper = CheckoutInfoListMapper(
            mapper = CheckoutInfoMapper(
                locale = Locale.getDefault(),
                currencySymbolText = context.getString(R.string.currency_symbol),
            ),
        ),
        locale = Locale.getDefault(),
        currencySymbolText = context.getString(R.string.currency_symbol),
    )

}
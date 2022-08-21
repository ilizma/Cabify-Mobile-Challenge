package com.ilizma.marketplace.domain.repository.di

import android.content.Context
import com.ilizma.marketplace.data.datasource.DiscountDataDataSource
import com.ilizma.marketplace.data.datasource.DiscountDescriptionDataSource
import com.ilizma.marketplace.data.mapper.DiscountDataOfferMapper
import com.ilizma.marketplace.data.mapper.DiscountDataQuantityMapper
import com.ilizma.marketplace.data.mapper.DiscountDescriptionMapper
import com.ilizma.marketplace.data.mapper.DiscountsMapper
import com.ilizma.marketplace.data.repository.DiscountRepositoryImp
import com.ilizma.marketplace.domain.repository.DiscountRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(FragmentComponent::class)
object DiscountRepositoryModule {

    @Provides
    fun provideDiscountRepository(
        @ApplicationContext context: Context,
        descriptionDataSource: DiscountDescriptionDataSource,
        dataDataSource: DiscountDataDataSource,
    ): DiscountRepository = DiscountRepositoryImp(
        descriptionDataSource = descriptionDataSource,
        dataDataSource = dataDataSource,
        mapper = DiscountsMapper(
            mapper = DiscountDescriptionMapper(
                quantityMapper = DiscountDataQuantityMapper(),
                offerMapper = DiscountDataOfferMapper(),
            ),
        ),
    )

}
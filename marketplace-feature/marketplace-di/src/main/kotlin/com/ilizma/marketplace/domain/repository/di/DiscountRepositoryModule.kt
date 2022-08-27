package com.ilizma.marketplace.domain.repository.di

import com.ilizma.marketplace.data.datasource.DiscountDataDataSource
import com.ilizma.marketplace.data.datasource.DiscountDescriptionDataSource
import com.ilizma.marketplace.data.mapper.*
import com.ilizma.marketplace.data.repository.DiscountRepositoryImp
import com.ilizma.marketplace.domain.repository.DiscountRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object DiscountRepositoryModule {

    @Provides
    fun provideDiscountRepository(
        descriptionDataSource: DiscountDescriptionDataSource,
        dataDataSource: DiscountDataDataSource,
    ): DiscountRepository = DiscountRepositoryImp(
        descriptionDataSource = descriptionDataSource,
        dataDataSource = dataDataSource,
        discountDescriptionsMapper = DiscountDescriptionsMapper(
            mapper = DiscountDescriptionMapper(
                quantityMapper = DiscountDataQuantityMapper(),
                offerMapper = DiscountDataOfferMapper(),
            ),
        ),
        discountDataListMapper = DiscountDataListMapper(
            mapper = DiscountDataMapper(),
        ),
    )

}
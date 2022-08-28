package com.ilizma.checkout.domain.usecase.di

import com.ilizma.checkout.domain.repository.CheckoutRepository
import com.ilizma.checkout.domain.usecase.GetCheckoutInfoListUseCase
import com.ilizma.checkout.domain.usecase.GetCheckoutInfoListUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object GetCheckoutInfoListUseCaseModule {

    @Provides
    fun provideGetCheckoutInfoListUseCase(
        repository: CheckoutRepository,
    ): GetCheckoutInfoListUseCase = GetCheckoutInfoListUseCaseImp(
        repository = repository,
    )

}
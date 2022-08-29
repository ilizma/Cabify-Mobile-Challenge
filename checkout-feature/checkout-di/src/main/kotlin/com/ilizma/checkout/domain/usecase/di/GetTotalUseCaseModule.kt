package com.ilizma.checkout.domain.usecase.di

import com.ilizma.checkout.domain.repository.CheckoutRepository
import com.ilizma.checkout.domain.usecase.GetTotalUseCase
import com.ilizma.checkout.domain.usecase.GetTotalUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object GetTotalUseCaseModule {

    @Provides
    fun provideGetTotalUseCase(
        repository: CheckoutRepository,
    ): GetTotalUseCase = GetTotalUseCaseImp(
        repository = repository,
    )

}
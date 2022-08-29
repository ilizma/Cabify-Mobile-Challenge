package com.ilizma.marketplace.domain.usecase.di

import com.ilizma.marketplace.domain.repository.ArticleRepository
import com.ilizma.marketplace.domain.usecase.GetArticleQuantityUseCase
import com.ilizma.marketplace.domain.usecase.GetArticleQuantityUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object GetArticleQuantityUseCaseModule {

    @Provides
    fun provideGetArticleQuantityUseCase(
        repository: ArticleRepository,
    ): GetArticleQuantityUseCase = GetArticleQuantityUseCaseImp(
        repository = repository,
    )

}
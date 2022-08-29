package com.ilizma.marketplace.domain.usecase.di

import com.ilizma.marketplace.domain.repository.ArticleRepository
import com.ilizma.marketplace.domain.usecase.AddArticleQuantityUseCase
import com.ilizma.marketplace.domain.usecase.AddArticleQuantityUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object AddArticleQuantityUseCaseModule {

    @Provides
    fun provideAddArticleQuantityUseCase(
        repository: ArticleRepository,
    ): AddArticleQuantityUseCase = AddArticleQuantityUseCaseImp(
        repository = repository,
    )

}
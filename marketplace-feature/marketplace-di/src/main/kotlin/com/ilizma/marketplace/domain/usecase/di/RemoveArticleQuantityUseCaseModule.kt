package com.ilizma.marketplace.domain.usecase.di

import com.ilizma.marketplace.domain.repository.ArticleRepository
import com.ilizma.marketplace.domain.usecase.RemoveArticleQuantityUseCase
import com.ilizma.marketplace.domain.usecase.RemoveArticleQuantityUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object RemoveArticleQuantityUseCaseModule {

    @Provides
    fun provideRemoveArticleQuantityUseCase(
        repository: ArticleRepository,
    ): RemoveArticleQuantityUseCase = RemoveArticleQuantityUseCaseImp(
        repository = repository,
    )

}
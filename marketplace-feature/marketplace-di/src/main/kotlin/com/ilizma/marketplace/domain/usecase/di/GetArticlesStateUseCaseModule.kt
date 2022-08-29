package com.ilizma.marketplace.domain.usecase.di

import com.ilizma.marketplace.domain.mapper.ArticleMapper
import com.ilizma.marketplace.domain.mapper.ArticlesStateMapper
import com.ilizma.marketplace.domain.repository.DiscountRepository
import com.ilizma.marketplace.domain.repository.ProductRepository
import com.ilizma.marketplace.domain.usecase.GetArticlesStateUseCase
import com.ilizma.marketplace.domain.usecase.GetArticlesStateUseCaseImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object GetArticlesStateUseCaseModule {

    @Provides
    fun provideGetArticlesStateUseCase(
        productRepository: ProductRepository,
        discountRepository: DiscountRepository,
    ): GetArticlesStateUseCase = GetArticlesStateUseCaseImp(
        productRepository = productRepository,
        discountRepository = discountRepository,
        mapper = ArticlesStateMapper(
            mapper = ArticleMapper()
        ),
    )

}
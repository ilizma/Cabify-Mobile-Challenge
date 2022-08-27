package com.ilizma.marketplace.domain.usecase.di

import android.content.Context
import com.ilizma.marketplace.domain.mapper.ArticleCheckoutInfoMapper
import com.ilizma.marketplace.domain.mapper.ArticlesCheckoutInfoMapper
import com.ilizma.marketplace.domain.repository.ArticleRepository
import com.ilizma.marketplace.domain.repository.DiscountRepository
import com.ilizma.marketplace.domain.repository.ProductRepository
import com.ilizma.marketplace.domain.usecase.GetArticlesCheckoutInfoUseCase
import com.ilizma.marketplace.domain.usecase.GetArticlesCheckoutInfoUseCaseImp
import com.ilizma.resources.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.*

@Module
@InstallIn(FragmentComponent::class)
object GetArticlesCheckoutInfoUseCaseModule {

    @Provides
    fun provideGetArticlesCheckoutInfoUseCase(
        @ApplicationContext context: Context,
        productRepository: ProductRepository,
        discountRepository: DiscountRepository,
        articleRepository: ArticleRepository,
    ): GetArticlesCheckoutInfoUseCase = GetArticlesCheckoutInfoUseCaseImp(
        productRepository = productRepository,
        discountRepository = discountRepository,
        articleRepository = articleRepository,
        mapper = ArticlesCheckoutInfoMapper(
            mapper = ArticleCheckoutInfoMapper(
                locale = Locale.getDefault(),
                moneyText = context.getString(R.string.money_symbol),
                promotionText = context.getString(R.string.promotion),
            )
        ),
    )

}
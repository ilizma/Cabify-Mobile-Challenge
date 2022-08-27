package com.ilizma.marketplace.domain.repository.di

import android.content.Context
import com.ilizma.marketplace.data.cache.ProductCache
import com.ilizma.marketplace.data.mapper.ProductMapper
import com.ilizma.marketplace.data.repository.ArticleRepositoryImp
import com.ilizma.marketplace.domain.repository.ArticleRepository
import com.ilizma.resources.R
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import java.util.*

@Module
@InstallIn(FragmentComponent::class)
object ArticleRepositoryModule {

    @Provides
    fun provideArticleRepository(
        @ApplicationContext context: Context,
        cache: ProductCache,
    ): ArticleRepository = ArticleRepositoryImp(
        cache = cache,
        mapper = ProductMapper(
            locale = Locale.getDefault(),
            moneyText = context.getString(R.string.money_symbol),
        ),
    )

}
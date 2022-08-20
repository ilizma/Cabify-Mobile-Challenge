package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.mapper.ArticlesMapper
import com.ilizma.marketplace.domain.model.Articles
import com.ilizma.marketplace.domain.repository.DiscountRepository
import com.ilizma.marketplace.domain.repository.ProductRepository
import io.reactivex.rxjava3.core.Single

class GetArticlesUseCaseImp(
    private val productRepository: ProductRepository,
    private val discountRepository: DiscountRepository,
    private val mapper: ArticlesMapper,
) : GetArticlesUseCase {

    override fun invoke(
    ): Single<Articles> = Single.zip(
        productRepository.getProducts(),
        discountRepository.getDiscounts(),
    ) { products, discounts ->
        mapper.from(products, discounts)
    }

}
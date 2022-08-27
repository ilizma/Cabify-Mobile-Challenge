package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.mapper.ArticlesStateMapper
import com.ilizma.marketplace.domain.model.ArticlesState
import com.ilizma.marketplace.domain.repository.DiscountRepository
import com.ilizma.marketplace.domain.repository.ProductRepository
import io.reactivex.rxjava3.core.Single

class GetArticlesStateUseCaseImp(
    private val productRepository: ProductRepository,
    private val discountRepository: DiscountRepository,
    private val mapper: ArticlesStateMapper,
) : GetArticlesStateUseCase {

    override fun invoke(
    ): Single<ArticlesState> = Single.zip(
        productRepository.getProductsState(),
        discountRepository.getDiscountsDescriptions(),
    ) { products, discounts ->
        mapper.from(products, discounts)
    }

}
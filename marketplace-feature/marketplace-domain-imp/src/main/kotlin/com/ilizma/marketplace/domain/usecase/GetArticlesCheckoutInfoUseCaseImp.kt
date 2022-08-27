package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.mapper.ArticlesCheckoutInfoMapper
import com.ilizma.marketplace.domain.model.ArticlesCheckoutInfo
import com.ilizma.marketplace.domain.model.DiscountDataList
import com.ilizma.marketplace.domain.model.Product
import com.ilizma.marketplace.domain.repository.ArticleRepository
import com.ilizma.marketplace.domain.repository.DiscountRepository
import com.ilizma.marketplace.domain.repository.ProductRepository
import io.reactivex.rxjava3.core.Single

class GetArticlesCheckoutInfoUseCaseImp(
    private val productRepository: ProductRepository,
    private val discountRepository: DiscountRepository,
    private val articleRepository: ArticleRepository,
    private val mapper: ArticlesCheckoutInfoMapper,
) : GetArticlesCheckoutInfoUseCase {

    override fun invoke(
    ): Single<ArticlesCheckoutInfo> = Single.zip(
        productRepository.getProductsFromLocal(),
        discountRepository.getDiscounts(),
    ) { products: List<Product>, discounts: DiscountDataList ->
        products.map { product ->
            articleRepository.getQuantity(product)
                .blockingGet()
                .let { product to it }
        }.let { mapper.from(products, it, discounts) }
    }

}
package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.mapper.ArticlesCheckoutInfoMapper
import com.ilizma.marketplace.domain.model.ArticlesCheckoutInfo
import com.ilizma.marketplace.domain.model.DiscountDataList
import com.ilizma.marketplace.domain.model.Product
import com.ilizma.marketplace.domain.repository.ArticleRepository
import com.ilizma.marketplace.domain.repository.DiscountRepository
import com.ilizma.marketplace.domain.repository.ProductRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

class GetArticlesCheckoutInfoUseCaseImpTest {

    @RelaxedMockK
    private lateinit var productRepository: ProductRepository

    @RelaxedMockK
    private lateinit var discountRepository: DiscountRepository

    @RelaxedMockK
    private lateinit var articleRepository: ArticleRepository

    @RelaxedMockK
    private lateinit var mapper: ArticlesCheckoutInfoMapper

    private lateinit var useCase: GetArticlesCheckoutInfoUseCase

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        useCase = GetArticlesCheckoutInfoUseCaseImp(
            productRepository = productRepository,
            discountRepository = discountRepository,
            articleRepository = articleRepository,
            mapper = mapper,
        )
    }

    @Nested
    inner class Invoke {

        @Test
        fun `given Article, when invoked, then result should be the expected Int`() {
            // given
            val name = "name"
            val product = mockk<Product>()
            val products = listOf(product)
            val discounts = mockk<DiscountDataList>()
            val quantity = 1
            val expected = mockk<ArticlesCheckoutInfo>()
            every { product.name } returns "name"
            every { productRepository.getProductsFromLocal() } returns Single.just(products)
            every { discountRepository.getDiscounts() } returns Single.just(discounts)
            every { articleRepository.getQuantity(name) } returns Single.just(quantity)
            every { mapper.from(products, any(), discounts) } returns expected

            // when
            val resultObserver = useCase()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}
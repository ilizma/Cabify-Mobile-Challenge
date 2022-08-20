package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.mapper.ArticlesMapper
import com.ilizma.marketplace.domain.model.Articles
import com.ilizma.marketplace.domain.model.Discounts
import com.ilizma.marketplace.domain.model.Products
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

internal class GetArticlesUseCaseImpTest {

    @RelaxedMockK
    private lateinit var productRepository: ProductRepository

    @RelaxedMockK
    private lateinit var discountRepository: DiscountRepository

    @RelaxedMockK
    private lateinit var mapper: ArticlesMapper

    private lateinit var useCase: GetArticlesUseCase

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        useCase = GetArticlesUseCaseImp(
            productRepository = productRepository,
            discountRepository = discountRepository,
            mapper = mapper,
        )
    }

    @Nested
    inner class Invoke {

        @Test
        fun `given Products and Discounts, when invoked, then result should be the expected Articles`() {
            // given
            val products = mockk<Products>()
            val discounts = mockk<Discounts>()
            val expected = mockk<Articles>()
            every { productRepository.getProducts() } returns Single.just(products)
            every { discountRepository.getDiscounts() } returns Single.just(discounts)
            every { mapper.from(products, discounts) } returns expected

            // when
            val resultObserver = useCase()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}
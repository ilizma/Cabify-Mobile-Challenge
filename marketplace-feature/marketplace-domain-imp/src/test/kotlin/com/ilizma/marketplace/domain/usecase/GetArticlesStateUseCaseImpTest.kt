package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.mapper.ArticlesStateMapper
import com.ilizma.marketplace.domain.model.ArticlesState
import com.ilizma.marketplace.domain.model.Discounts
import com.ilizma.marketplace.domain.model.ProductsState
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

internal class GetArticlesStateUseCaseImpTest {

    @RelaxedMockK
    private lateinit var productRepository: ProductRepository

    @RelaxedMockK
    private lateinit var discountRepository: DiscountRepository

    @RelaxedMockK
    private lateinit var mapper: ArticlesStateMapper

    private lateinit var useCase: GetArticlesStateUseCase

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        useCase = GetArticlesStateUseCaseImp(
            productRepository = productRepository,
            discountRepository = discountRepository,
            mapper = mapper,
        )
    }

    @Nested
    inner class Invoke {

        @Test
        fun `given ProductsState and Discounts, when invoked, then result should be the expected Articles`() {
            // given
            val state = mockk<ProductsState>()
            val discounts = mockk<Discounts>()
            val expected = mockk<ArticlesState>()
            every { productRepository.getProductsState() } returns Single.just(state)
            every { discountRepository.getDiscounts() } returns Single.just(discounts)
            every { mapper.from(state, discounts) } returns expected

            // when
            val resultObserver = useCase()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}
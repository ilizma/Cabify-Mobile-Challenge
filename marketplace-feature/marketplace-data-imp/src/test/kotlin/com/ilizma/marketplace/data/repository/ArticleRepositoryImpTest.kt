package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.cache.ProductCache
import com.ilizma.marketplace.data.mapper.ProductMapper
import com.ilizma.marketplace.data.model.Product
import com.ilizma.marketplace.domain.model.Article
import com.ilizma.marketplace.domain.repository.ArticleRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ArticleRepositoryImpTest {

    @RelaxedMockK
    private lateinit var cache: ProductCache

    @RelaxedMockK
    private lateinit var mapper: ProductMapper

    private lateinit var repository: ArticleRepository

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        repository = ArticleRepositoryImp(
            cache = cache,
            mapper = mapper,
        )
    }

    @Nested
    inner class GetQuantity {

        @Test
        fun `given article, when getQuantity, then result should be the expected Int`() {
            // given
            val article = mockk<Article>()
            val dataProduct = mockk<Product>()
            val expected = 0
            every { mapper.from(article) } returns dataProduct
            every { cache.get(dataProduct) } returns Single.just(expected)

            // when
            val resultObserver = repository.getQuantity(article)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

    @Nested
    inner class AddQuantity {

        @Test
        fun `given article, when addQuantity, then result should be complete`() {
            // given
            val article = mockk<Article>()
            val dataProduct = mockk<Product>()
            val expected = 0
            every { mapper.from(article) } returns dataProduct
            every { cache.get(dataProduct) } returns Single.just(expected)

            // when
            val resultObserver = repository.addQuantity(article)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertComplete()
        }

    }

    @Nested
    inner class RemoveQuantity {

        @Test
        fun `given article, when removeQuantity, then result should be complete`() {
            // given
            val article = mockk<Article>()
            val dataProduct = mockk<Product>()
            val expected = 0
            every { mapper.from(article) } returns dataProduct
            every { cache.get(dataProduct) } returns Single.just(expected)

            // when
            val resultObserver = repository.removeQuantity(article)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertComplete()
        }

    }

}
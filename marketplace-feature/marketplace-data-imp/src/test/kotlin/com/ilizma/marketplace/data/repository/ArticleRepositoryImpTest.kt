package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.cache.ProductQuantityCache
import com.ilizma.marketplace.domain.repository.ArticleRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ArticleRepositoryImpTest {

    @RelaxedMockK
    private lateinit var cache: ProductQuantityCache

    private lateinit var repository: ArticleRepository

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        repository = ArticleRepositoryImp(
            cache = cache,
        )
    }

    @Nested
    inner class GetQuantity {

        @Test
        fun `given articleName, when getQuantity, then result should be the expected Int`() {
            // given
            val articleName = "articleName"
            val expected = 0
            every { cache.get(articleName) } returns Single.just(expected)

            // when
            val resultObserver = repository.getQuantity(articleName)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

    @Nested
    inner class AddQuantity {

        @Test
        fun `given articleName, when addQuantity, then result should be complete`() {
            // given
            val articleName = "articleName"
            val expected = 0
            every { cache.get(articleName) } returns Single.just(expected)

            // when
            val resultObserver = repository.addQuantity(articleName)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertComplete()
        }

    }

    @Nested
    inner class RemoveQuantity {

        @Test
        fun `given articleName, when removeQuantity, then result should be complete`() {
            // given
            val articleName = "articleName"
            val expected = 0
            every { cache.get(articleName) } returns Single.just(expected)

            // when
            val resultObserver = repository.removeQuantity(articleName)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertComplete()
        }

    }

}
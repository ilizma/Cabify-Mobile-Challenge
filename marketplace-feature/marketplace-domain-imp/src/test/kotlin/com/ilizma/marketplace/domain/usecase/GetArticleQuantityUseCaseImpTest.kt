package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.repository.ArticleRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class GetArticleQuantityUseCaseImpTest {

    @RelaxedMockK
    private lateinit var repository: ArticleRepository

    private lateinit var useCase: GetArticleQuantityUseCase

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        useCase = GetArticleQuantityUseCaseImp(
            repository = repository,
        )
    }

    @Nested
    inner class Invoke {

        @Test
        fun `given Article, when invoked, then result should be the expected Int`() {
            // given
            val articleName = "articleName"
            val expected = 0
            every { repository.getQuantity(articleName) } returns Single.just(expected)

            // when
            val resultObserver = useCase(articleName)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}
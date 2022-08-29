package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.repository.ArticleRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class RemoveArticleQuantityUseCaseImpTest {

    @RelaxedMockK
    private lateinit var repository: ArticleRepository

    private lateinit var useCase: RemoveArticleQuantityUseCase

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        useCase = RemoveArticleQuantityUseCaseImp(
            repository = repository,
        )
    }

    @Nested
    inner class Invoke {

        @Test
        fun `given Article, when invoked, then result should be complete`() {
            // given
            val articleName = "articleName"
            every { repository.removeQuantity(articleName) } returns Completable.complete()

            // when
            val resultObserver = useCase(articleName)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertComplete()
        }

    }

}
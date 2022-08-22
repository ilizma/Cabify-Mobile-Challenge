package com.ilizma.marketplace.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import com.ilizma.marketplace.domain.model.Article
import com.ilizma.marketplace.domain.usecase.AddArticleQuantityUseCase
import com.ilizma.marketplace.domain.usecase.GetArticleQuantityUseCase
import com.ilizma.marketplace.domain.usecase.RemoveArticleQuantityUseCase
import com.ilizma.marketplace.presentation.mapper.ArticleMapper
import com.ilizma.test.executor.InstantExecutorExtension
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import com.ilizma.marketplace.presentation.model.Article as PresentationArticle

@ExtendWith(InstantExecutorExtension::class)
internal class ArticleViewModelImpTest {

    @RelaxedMockK
    private lateinit var getArticleQuantityUseCase: GetArticleQuantityUseCase

    @RelaxedMockK
    private lateinit var addArticleQuantityUseCase: AddArticleQuantityUseCase

    @RelaxedMockK
    private lateinit var removeArticleQuantityUseCase: RemoveArticleQuantityUseCase

    @RelaxedMockK
    private lateinit var mapper: ArticleMapper

    @RelaxedMockK
    private lateinit var compositeDisposable: CompositeDisposable

    private lateinit var viewModel: ArticleViewModel

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        viewModel = ArticleViewModelImp(
            getArticleQuantityUseCase = getArticleQuantityUseCase,
            addArticleQuantityUseCase = addArticleQuantityUseCase,
            removeArticleQuantityUseCase = removeArticleQuantityUseCase,
            mapper = mapper,
            backgroundScheduler = Schedulers.trampoline(),
            compositeDisposable = compositeDisposable,
            _quantity = MutableLiveData(),
        )
    }

    @Nested
    inner class GetArticleQuantity {

        @Test
        fun `given presentationArticle, when getArticleQuantity, then the quantity liveData value should be the expected Int`() {
            // given
            val presentationArticle = mockk<PresentationArticle.Success>()
            val article = mockk<Article>()
            val expected = 0
            every { mapper.from(presentationArticle) } returns article
            every { getArticleQuantityUseCase(article) } returns Single.just(expected)

            // when
            viewModel.getArticleQuantity(presentationArticle)

            // then
            assertEquals(expected, viewModel.quantity.value)
        }

    }

    @Nested
    inner class OnPlus {

        @Test
        fun `given presentationArticle, when onPlus, then the quantity liveData value should be the expected Int`() {
            // given
            val presentationArticle = mockk<PresentationArticle.Success>()
            val article = mockk<Article>()
            val expected = 0
            every { mapper.from(presentationArticle) } returns article
            every { addArticleQuantityUseCase(article) } returns Completable.complete()
            every { getArticleQuantityUseCase(article) } returns Single.just(expected)

            // when
            viewModel.onPlus(presentationArticle)

            // then
            assertEquals(expected, viewModel.quantity.value)
        }

    }

    @Nested
    inner class OnMinus {

        @Test
        fun `given presentationArticle, when onMinus, then the quantity liveData value should be the expected Int`() {
            // given
            val presentationArticle = mockk<PresentationArticle.Success>()
            val article = mockk<Article>()
            val expected = 0
            every { mapper.from(presentationArticle) } returns article
            every { removeArticleQuantityUseCase(article) } returns Completable.complete()
            every { getArticleQuantityUseCase(article) } returns Single.just(expected)

            // when
            viewModel.onMinus(presentationArticle)

            // then
            assertEquals(expected, viewModel.quantity.value)
        }

    }

}
package com.ilizma.marketplace.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilizma.marketplace.domain.usecase.AddArticleQuantityUseCase
import com.ilizma.marketplace.domain.usecase.GetArticleQuantityUseCase
import com.ilizma.marketplace.domain.usecase.RemoveArticleQuantityUseCase
import com.ilizma.marketplace.presentation.mapper.ArticleMapper
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import com.ilizma.marketplace.presentation.model.Article as PresentationArticle

class ArticleViewModelImp @AssistedInject constructor(
    private val getArticleQuantityUseCase: GetArticleQuantityUseCase,
    private val addArticleQuantityUseCase: AddArticleQuantityUseCase,
    private val removeArticleQuantityUseCase: RemoveArticleQuantityUseCase,
    @Assisted private val mapper: ArticleMapper,
    @Assisted private val backgroundScheduler: Scheduler,
    @Assisted private val compositeDisposable: CompositeDisposable,
    @Assisted private val _quantity: MutableLiveData<Int>,
) : ArticleViewModel() {

    override val quantity: LiveData<Int> = _quantity

    override fun getArticleQuantity(article: PresentationArticle.Success) {
        mapper.from(article)
            .let { getArticleQuantityUseCase(it) }
            .subscribeOn(backgroundScheduler)
            .observeOn(backgroundScheduler)
            .subscribe(::onQuantity) { throw it }
            .addTo(compositeDisposable)
    }

    override fun onPlus(article: PresentationArticle.Success) {
        mapper.from(article)
            .let { addArticleQuantityUseCase(it) }
            .subscribeOn(backgroundScheduler)
            .observeOn(backgroundScheduler)
            .subscribe({ getArticleQuantity(article) }) { throw it }
            .addTo(compositeDisposable)
    }

    override fun onMinus(article: PresentationArticle.Success) {
        mapper.from(article)
            .let { removeArticleQuantityUseCase(it) }
            .subscribeOn(backgroundScheduler)
            .observeOn(backgroundScheduler)
            .subscribe({ getArticleQuantity(article) }) { throw it }
            .addTo(compositeDisposable)
    }

    private fun onQuantity(
        quantity: Int,
    ) {
        _quantity.postValue(quantity)
    }

}

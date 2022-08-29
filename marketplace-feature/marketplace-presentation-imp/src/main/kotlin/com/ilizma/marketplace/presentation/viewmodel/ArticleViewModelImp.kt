package com.ilizma.marketplace.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilizma.marketplace.domain.usecase.AddArticleQuantityUseCase
import com.ilizma.marketplace.domain.usecase.GetArticleQuantityUseCase
import com.ilizma.marketplace.domain.usecase.RemoveArticleQuantityUseCase
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo

class ArticleViewModelImp @AssistedInject constructor(
    private val getArticleQuantityUseCase: GetArticleQuantityUseCase,
    private val addArticleQuantityUseCase: AddArticleQuantityUseCase,
    private val removeArticleQuantityUseCase: RemoveArticleQuantityUseCase,
    @Assisted private val backgroundScheduler: Scheduler,
    @Assisted private val compositeDisposable: CompositeDisposable,
    @Assisted private val _quantity: MutableLiveData<Int>,
) : ArticleViewModel() {

    override val quantity: LiveData<Int> = _quantity

    override fun getArticleQuantity(articleName: String) {
        getArticleQuantityUseCase(articleName)
            .subscribeOn(backgroundScheduler)
            .observeOn(backgroundScheduler)
            .subscribe(::onQuantity) { throw it }
            .addTo(compositeDisposable)
    }

    override fun onPlus(articleName: String) {
        addArticleQuantityUseCase(articleName)
            .subscribeOn(backgroundScheduler)
            .observeOn(backgroundScheduler)
            .subscribe({ getArticleQuantity(articleName) }) { throw it }
            .addTo(compositeDisposable)
    }

    override fun onMinus(articleName: String) {
        removeArticleQuantityUseCase(articleName)
            .subscribeOn(backgroundScheduler)
            .observeOn(backgroundScheduler)
            .subscribe({ getArticleQuantity(articleName) }) { throw it }
            .addTo(compositeDisposable)
    }

    private fun onQuantity(
        quantity: Int,
    ) {
        _quantity.postValue(quantity)
    }

}

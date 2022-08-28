package com.ilizma.checkout.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ilizma.checkout.domain.model.CheckoutInfoList
import com.ilizma.checkout.presentation.mapper.CheckoutInfoListMapper
import com.ilizma.checkout.presentation.model.CheckoutNavigationAction
import com.ilizma.checkout.presentation.model.CheckoutNavigationAction.*
import com.ilizma.checkout.domain.usecase.GetCheckoutInfoListUseCase
import com.ilizma.presentation.SingleLiveEvent
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.kotlin.addTo
import com.ilizma.checkout.presentation.model.CheckoutInfoList as PresentationCheckoutInfoList

class CheckoutViewModelImp @AssistedInject constructor(
    private val useCase: GetCheckoutInfoListUseCase,
    @Assisted private val mapper: CheckoutInfoListMapper,
    @Assisted private val backgroundScheduler: Scheduler,
    @Assisted private val compositeDisposable: CompositeDisposable,
    @Assisted private val _list: MutableLiveData<PresentationCheckoutInfoList>,
    @Assisted private val _navigationAction: SingleLiveEvent<CheckoutNavigationAction>,
) : CheckoutViewModel() {

    override val list: LiveData<PresentationCheckoutInfoList> = _list
    override val navigationAction: LiveData<CheckoutNavigationAction> = _navigationAction

    init {
        getCheckoutInfoList()
    }

    override fun onBack() {
        _navigationAction.postValue(BACK)
    }

    private fun getCheckoutInfoList() {
        useCase()
            .subscribeOn(backgroundScheduler)
            .observeOn(backgroundScheduler)
            .subscribe(::onCheckoutInfoList) { throw it }
            .addTo(compositeDisposable)
    }

    private fun onCheckoutInfoList(
        list: CheckoutInfoList,
    ) {
        mapper.from(list)
            .let { _list.postValue(it) }
    }

}

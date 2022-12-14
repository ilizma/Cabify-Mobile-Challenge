package com.ilizma.checkout.presentation.viewmodel.factory

import androidx.lifecycle.MutableLiveData
import com.ilizma.checkout.presentation.mapper.CheckoutInfoListMapper
import com.ilizma.checkout.presentation.model.CheckoutInfoList
import com.ilizma.checkout.presentation.model.CheckoutNavigationAction
import com.ilizma.checkout.presentation.viewmodel.CheckoutViewModelImp
import com.ilizma.presentation.SingleLiveEvent
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable

const val TOTAL_ASSISTED = "TOTAL_ASSISTED"

@AssistedFactory
interface CheckoutViewModelAssistedFactory {

    fun create(
        mapper: CheckoutInfoListMapper,
        backgroundScheduler: Scheduler,
        compositeDisposable: CompositeDisposable,
        _list: MutableLiveData<CheckoutInfoList>,
        @Assisted(TOTAL_ASSISTED) _total: MutableLiveData<String>,
        _navigationAction: SingleLiveEvent<CheckoutNavigationAction>,
    ): CheckoutViewModelImp

}
package com.ilizma.checkout.presentation.viewmodel.factory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ilizma.checkout.presentation.mapper.CheckoutInfoListMapper
import com.ilizma.checkout.presentation.mapper.CheckoutInfoMapper
import com.ilizma.presentation.SingleLiveEvent
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class CheckoutViewModelFactory(
    private val viewModelAssistedFactory: CheckoutViewModelAssistedFactory,
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>,
    ): T = viewModelAssistedFactory.create(
        mapper = CheckoutInfoListMapper(
            mapper = CheckoutInfoMapper()
        ),
        backgroundScheduler = Schedulers.io(),
        compositeDisposable = CompositeDisposable(),
        _list = MutableLiveData(),
        _total = MutableLiveData(),
        _navigationAction = SingleLiveEvent(),
    ) as T

}
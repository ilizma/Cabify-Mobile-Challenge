package com.ilizma.test.lifecycle

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer

class TestMutableLiveData<T> : MutableLiveData<T>() {

    private var observer: Observer<in T>? = null

    override fun observe(owner: LifecycleOwner, observer: Observer<in T>) {
        this.observer = observer
    }

    fun onChanged(value: T) {
        observer?.onChanged(value)
    }

}
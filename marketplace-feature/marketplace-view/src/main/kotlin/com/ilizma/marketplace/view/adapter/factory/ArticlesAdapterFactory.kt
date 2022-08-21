package com.ilizma.marketplace.view.adapter.factory

import com.ilizma.marketplace.view.adapter.ArticlesAdapter

interface ArticlesAdapterFactory<T> {

    fun create(): ArticlesAdapter<T>

}
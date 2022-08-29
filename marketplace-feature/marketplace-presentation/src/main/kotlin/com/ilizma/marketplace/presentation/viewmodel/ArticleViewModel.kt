package com.ilizma.marketplace.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ilizma.marketplace.presentation.model.Article

abstract class ArticleViewModel : ViewModel() {

    abstract val quantity: LiveData<Int>

    abstract fun getArticleQuantity(articleName: String)

    abstract fun onPlus(articleName: String)

    abstract fun onMinus(articleName: String)

}
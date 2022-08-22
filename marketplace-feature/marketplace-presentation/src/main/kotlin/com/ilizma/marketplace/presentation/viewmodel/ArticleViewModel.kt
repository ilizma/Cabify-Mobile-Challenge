package com.ilizma.marketplace.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ilizma.marketplace.presentation.model.Article

abstract class ArticleViewModel : ViewModel() {

    abstract val quantity: LiveData<Int>

    abstract fun getArticleQuantity(article: Article.Success)

    abstract fun onPlus(article: Article.Success)

    abstract fun onMinus(article: Article.Success)

}
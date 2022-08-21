package com.ilizma.marketplace.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.presentation.model.ArticlesState
import com.ilizma.marketplace.presentation.model.MarketplaceNavigationAction

abstract class MarketplaceViewModel : ViewModel() {

    abstract val state: LiveData<ArticlesState>

    abstract val error: LiveData<String>

    abstract val navigationAction: LiveData<MarketplaceNavigationAction>

    abstract fun getState()

    abstract fun onItemSelected(article: Article.Success)

    abstract fun onCheckout()

}
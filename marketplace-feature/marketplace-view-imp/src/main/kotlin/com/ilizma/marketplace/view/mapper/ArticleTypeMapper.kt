package com.ilizma.marketplace.view.mapper

import com.ilizma.marketplace.view.model.ArticleType
import com.ilizma.marketplace.view.model.ArticleType.TYPE_ITEM
import com.ilizma.marketplace.view.model.ArticleType.TYPE_LOADING

class ArticleTypeMapper {

    fun from(
        viewType: Int,
    ): ArticleType = when (viewType) {
        TYPE_ITEM.ordinal -> TYPE_ITEM
        TYPE_LOADING.ordinal -> TYPE_LOADING
        else -> throw IllegalArgumentException("Invalid view type: $viewType")
    }

}
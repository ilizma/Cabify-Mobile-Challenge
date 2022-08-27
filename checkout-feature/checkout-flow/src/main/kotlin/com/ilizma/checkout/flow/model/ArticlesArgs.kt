package com.ilizma.checkout.flow.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ArticlesArgs(
    val list: List<ArticleArgs>,
) : Parcelable
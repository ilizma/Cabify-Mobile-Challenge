package com.ilizma.marketplace.view.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class ArticleViewHolder<T>(
    itemView: View,
) : RecyclerView.ViewHolder(itemView) {

    abstract fun bind(article: T, position: Int)

    abstract fun unBind()

} 
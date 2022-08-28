package com.ilizma.checkout.view.adapter.util

import com.ilizma.checkout.presentation.model.CheckoutInfo
import com.ilizma.view.adapter.util.ItemDiffUtil

class CheckoutItemDiffUtilImp : ItemDiffUtil<CheckoutInfo>() {

    override fun areItemsTheSame(
        oldItem: CheckoutInfo,
        newItem: CheckoutInfo,
    ): Boolean = oldItem.name == newItem.name

    override fun areContentsTheSame(
        oldItem: CheckoutInfo,
        newItem: CheckoutInfo,
    ): Boolean = oldItem == newItem

} 
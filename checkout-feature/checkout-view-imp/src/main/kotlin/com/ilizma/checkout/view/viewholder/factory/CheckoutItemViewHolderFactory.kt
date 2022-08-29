package com.ilizma.checkout.view.viewholder.factory

import android.view.LayoutInflater
import android.view.ViewGroup
import com.ilizma.checkout.presentation.model.CheckoutInfo
import com.ilizma.checkout.view.bind.CheckoutItemBinderImp
import com.ilizma.checkout.view.databinding.CheckoutItemBinding
import com.ilizma.checkout.view.viewholder.CheckoutItemViewHolderImp
import com.ilizma.view.viewholder.ViewHolder

class CheckoutItemViewHolderFactory {

    fun create(
        parent: ViewGroup,
    ): ViewHolder<CheckoutInfo> = LayoutInflater.from(parent.context)
        .let { viewHolder(it, parent) }

    private fun viewHolder(
        inflater: LayoutInflater,
        parent: ViewGroup,
    ): ViewHolder<CheckoutInfo> = CheckoutItemBinding.inflate(inflater, parent, false)
        .let { CheckoutItemViewHolderImp(binder = CheckoutItemBinderImp(), binding = it) }

}
package com.ilizma.checkout.view.viewholder

import com.ilizma.checkout.presentation.model.CheckoutInfo
import com.ilizma.checkout.view.bind.CheckoutItemBinder
import com.ilizma.checkout.view.databinding.CheckoutItemBinding
import com.ilizma.view.viewholder.ViewHolder

class CheckoutItemViewHolderImp(
    private val binder: CheckoutItemBinder<CheckoutInfo>,
    private val binding: CheckoutItemBinding,
) : ViewHolder<CheckoutInfo>(binding.root) {

    override fun bind(checkoutInfo: CheckoutInfo) {
        binder.bind(binding, checkoutInfo)
    }

    override fun unBind() { /* Do nothing */ }

}
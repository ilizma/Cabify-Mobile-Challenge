package com.ilizma.checkout.view.bind

import com.ilizma.checkout.view.databinding.CheckoutItemBinding

interface CheckoutItemBinder<T> {

    fun bind(binding: CheckoutItemBinding, checkoutInfo: T)

}
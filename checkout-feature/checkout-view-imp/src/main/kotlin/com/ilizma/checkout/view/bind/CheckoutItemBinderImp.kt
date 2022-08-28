package com.ilizma.checkout.view.bind

import android.graphics.Paint
import com.ilizma.checkout.presentation.model.CheckoutInfo
import com.ilizma.checkout.view.databinding.CheckoutItemBinding

class CheckoutItemBinderImp : CheckoutItemBinder<CheckoutInfo> {

    override fun bind(binding: CheckoutItemBinding, checkoutInfo: CheckoutInfo) {
        setupView(binding, checkoutInfo)
    }

    private fun setupView(
        binding: CheckoutItemBinding,
        checkoutInfo: CheckoutInfo,
    ) {
        (binding.checkoutItemTvOldPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG)
            .let { binding.checkoutItemTvOldPrice.paintFlags = it }
        binding.checkoutItemTvName.text = checkoutInfo.name
        binding.checkoutItemTvPrice.text = checkoutInfo.price
        checkoutInfo.oldPrice?.let { binding.checkoutItemTvOldPrice.text = it }
        checkoutInfo.promotion?.let { binding.checkoutItemTvPromotion.text = it }
    }

}
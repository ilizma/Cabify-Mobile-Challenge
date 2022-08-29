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
        binding.checkoutItemTvQuantity.text = checkoutInfo.quantity.toString()
        binding.checkoutItemTvPrice.text = checkoutInfo.priceWithSymbol
        binding.checkoutItemTvTotalPrice.text = checkoutInfo.totalPriceWithSymbol
        checkoutInfo.oldPrice?.let { binding.checkoutItemTvOldPrice.text = it }
        checkoutInfo.promotion?.let { binding.checkoutItemTvPromotion.text = it }
    }

}
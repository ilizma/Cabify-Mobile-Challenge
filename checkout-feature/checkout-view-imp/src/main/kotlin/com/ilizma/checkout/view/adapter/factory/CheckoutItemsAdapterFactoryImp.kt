package com.ilizma.checkout.view.adapter.factory

import com.ilizma.checkout.presentation.model.CheckoutInfo
import com.ilizma.checkout.view.adapter.CheckoutItemsAdapterImp
import com.ilizma.checkout.view.viewholder.factory.CheckoutItemViewHolderFactory
import com.ilizma.view.adapter.Adapter
import com.ilizma.view.adapter.factory.AdapterFactory
import com.ilizma.view.adapter.util.ItemDiffUtil

class CheckoutItemsAdapterFactoryImp(
    private val diffUtil: ItemDiffUtil<CheckoutInfo>,
    private val viewHolderFactory: CheckoutItemViewHolderFactory,
) : AdapterFactory<CheckoutInfo> {

    override fun create(
    ): Adapter<CheckoutInfo> = CheckoutItemsAdapterImp(
        liveChannelItemDiffUtil = diffUtil,
        viewHolderFactory = viewHolderFactory,
    )

}
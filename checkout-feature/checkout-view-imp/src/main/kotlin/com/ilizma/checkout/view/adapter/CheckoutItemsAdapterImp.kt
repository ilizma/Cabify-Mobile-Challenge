package com.ilizma.checkout.view.adapter

import android.view.ViewGroup
import com.ilizma.checkout.presentation.model.CheckoutInfo
import com.ilizma.checkout.view.viewholder.factory.CheckoutItemViewHolderFactory
import com.ilizma.view.adapter.Adapter
import com.ilizma.view.adapter.util.ItemDiffUtil
import com.ilizma.view.viewholder.ViewHolder

class CheckoutItemsAdapterImp(
    liveChannelItemDiffUtil: ItemDiffUtil<CheckoutInfo>,
    private val viewHolderFactory: CheckoutItemViewHolderFactory,
) : Adapter<CheckoutInfo>(liveChannelItemDiffUtil) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): ViewHolder<CheckoutInfo> = viewHolderFactory.create(
        parent = parent,
    )

    override fun onBindViewHolder(holder: ViewHolder<CheckoutInfo>, position: Int) {
        getItem(position).let { holder.bind(it) }
    }

    override fun onViewRecycled(holder: ViewHolder<CheckoutInfo>) {
        super.onViewRecycled(holder)
        holder.unBind()
    }

}

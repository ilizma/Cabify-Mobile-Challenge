package com.ilizma.checkout.view.adapter

import android.view.ViewGroup
import com.ilizma.checkout.presentation.model.CheckoutInfo
import com.ilizma.checkout.view.viewholder.factory.CheckoutItemViewHolderFactory
import com.ilizma.view.adapter.Adapter
import com.ilizma.view.adapter.util.ItemDiffUtil
import com.ilizma.view.viewholder.ViewHolder
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class CheckoutItemsAdapterImpTest {

    @RelaxedMockK
    private lateinit var itemDiffUtil: ItemDiffUtil<CheckoutInfo>

    @RelaxedMockK
    private lateinit var viewHolderFactory: CheckoutItemViewHolderFactory

    private lateinit var adapter: Adapter<CheckoutInfo>

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        adapter = CheckoutItemsAdapterImp(
            liveChannelItemDiffUtil = itemDiffUtil,
            viewHolderFactory = viewHolderFactory,
        )
    }

    @Nested
    inner class OnCreateViewHolder {

        @Test
        fun `given parent and viewType, when onCreateViewHolder is called, then result should be the expected CheckoutItemViewHolder`() {
            // given
            val parent = mockk<ViewGroup>()
            val expected = mockk<ViewHolder<CheckoutInfo>>()
            every { viewHolderFactory.create(parent = parent) } returns expected

            // when
            val result = adapter.onCreateViewHolder(parent, 0)

            // then
            assertEquals(expected, result)
        }

    }

}
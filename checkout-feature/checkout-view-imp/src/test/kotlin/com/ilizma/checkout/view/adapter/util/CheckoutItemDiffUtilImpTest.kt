package com.ilizma.checkout.view.adapter.util

import com.ilizma.checkout.presentation.model.CheckoutInfo
import com.ilizma.view.adapter.util.ItemDiffUtil
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class CheckoutItemDiffUtilImpTest {

    private lateinit var itemDiffUtil: ItemDiffUtil<CheckoutInfo>

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        itemDiffUtil = CheckoutItemDiffUtilImp()
    }

    @Nested
    inner class AreItemsTheSame {

        @Test
        fun `given oldItem and newItem with the same name, when areItemsTheSame is called, then result should be the expected true`() {
            // given
            val name = "name"
            val oldItem = mockk<CheckoutInfo>()
            val newItem = mockk<CheckoutInfo>()
            val expected = true
            every { oldItem.name } returns name
            every { newItem.name } returns name

            // when
            val result = itemDiffUtil.areItemsTheSame(
                oldItem,
                newItem,
            )

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given oldItem and newItem with different names, when areItemsTheSame is called, then result should be the expected false`() {
            // given
            val name = "name"
            val otherName = "otherName"
            val oldItem = mockk<CheckoutInfo>()
            val newItem = mockk<CheckoutInfo>()
            val expected = false
            every { oldItem.name } returns name
            every { newItem.name } returns otherName

            // when
            val result = itemDiffUtil.areItemsTheSame(
                oldItem,
                newItem,
            )

            // then
            assertEquals(expected, result)
        }

    }

    @Nested
    inner class AreContentsTheSame {

        @Test
        fun `given same oldItem and newItem, when areContentsTheSame is called, then result should be the expected true`() {
            // given
            val item = mockk<CheckoutInfo>()
            val expected = true

            // when
            val result = itemDiffUtil.areContentsTheSame(
                item,
                item,
            )

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given different oldItem and newItem, when areContentsTheSame is called, then result should be the expected false`() {
            // given
            val oldItem = mockk<CheckoutInfo>()
            val newItem = mockk<CheckoutInfo>()
            val expected = false

            // when
            val result = itemDiffUtil.areContentsTheSame(
                oldItem,
                newItem,
            )

            // then
            assertEquals(expected, result)
        }

    }

}
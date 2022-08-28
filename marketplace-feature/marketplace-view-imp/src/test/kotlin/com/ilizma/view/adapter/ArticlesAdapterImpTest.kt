package com.ilizma.view.adapter

import android.view.ViewGroup
import com.ilizma.marketplace.presentation.model.Article
import com.ilizma.marketplace.view.adapter.ArticlesAdapterImp
import com.ilizma.view.adapter.util.ItemDiffUtil
import com.ilizma.marketplace.view.bind.factory.ArticleBinderFactory
import com.ilizma.marketplace.view.mapper.ArticleTypeMapper
import com.ilizma.marketplace.view.model.ArticleType
import com.ilizma.view.viewholder.ViewHolder
import com.ilizma.marketplace.view.viewholder.factory.ArticleViewHolderFactory
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ArticlesAdapterImpTest {

    @RelaxedMockK
    private lateinit var binderFactory: ArticleBinderFactory

    @RelaxedMockK
    private lateinit var itemDiffUtil: ItemDiffUtil<Article>

    @RelaxedMockK
    private lateinit var viewHolderFactory: ArticleViewHolderFactory

    @RelaxedMockK
    private lateinit var mapper: ArticleTypeMapper

    private lateinit var adapter: Adapter<Article>

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        adapter = ArticlesAdapterImp(
            binderFactory = binderFactory,
            liveChannelItemDiffUtil = itemDiffUtil,
            viewHolderFactory = viewHolderFactory,
            mapper = mapper,
        )
    }

    @Nested
    inner class OnCreateViewHolder {

        @Test
        fun `given parent and viewType, when onCreateViewHolder is called, then result should be the expected ArticleViewHolder`() {
            // given
            val parent = mockk<ViewGroup>()
            val viewType = mockk<ArticleType>()
            val expected = mockk<ViewHolder<Article>>()
            every { viewType.ordinal } returns 0
            every { mapper.from(viewType.ordinal) } returns viewType
            every {
                viewHolderFactory.create(
                    binderFactory = binderFactory,
                    parent = parent,
                    type = viewType,
                )
            } returns expected

            // when
            val result = adapter.onCreateViewHolder(
                parent,
                viewType.ordinal,
            )

            // then
            assertEquals(expected, result)
        }

    }

}
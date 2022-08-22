package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.cache.ProductSuccessCache
import com.ilizma.marketplace.data.datasource.ProductDataSource
import com.ilizma.marketplace.data.mapper.ProductsStateMapper
import com.ilizma.marketplace.domain.model.ProductsState
import com.ilizma.marketplace.domain.repository.ProductRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.mockk.verify
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import com.ilizma.marketplace.data.model.ProductsState as DataProductsState

internal class ProductRepositoryImpTest {

    @RelaxedMockK
    private lateinit var dataSource: ProductDataSource

    @RelaxedMockK
    private lateinit var cache: ProductSuccessCache

    @RelaxedMockK
    private lateinit var mapper: ProductsStateMapper

    private lateinit var repository: ProductRepository

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        repository = ProductRepositoryImp(
            dataSource = dataSource,
            cache = cache,
            mapper = mapper,
        )
    }

    @Nested
    inner class GetProductsStateState {

        @Test
        fun `given Success DataProductsState and null cache, when getPlayerName, then result should be the expected ProductsState`() {
            // given
            val dataState = mockk<DataProductsState.Success>()
            val expected = mockk<ProductsState.Success>()
            every { cache.get() } returns null
            every { dataSource.getProductsState() } returns Single.just(dataState)
            every { mapper.from(dataState) } returns expected

            // when
            val resultObserver = repository.getProductsState()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
            verify { cache.set(dataState) }
        }

        @Test
        fun `given RemoteError DataProductsState and null cache, when getPlayerName, then result should be the expected ProductsState`() {
            // given
            val dataState = mockk<DataProductsState.RemoteError>()
            val expected = mockk<ProductsState.RemoteError>()
            every { cache.get() } returns null
            every { dataSource.getProductsState() } returns Single.just(dataState)
            every { mapper.from(dataState) } returns expected

            // when
            val resultObserver = repository.getProductsState()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
            verify(exactly = 0) { cache.set(any()) }
        }

        @Test
        fun `given Success DataProductsState and cache, when getPlayerName, then result should be the expected ProductsState`() {
            // given
            val dataState = mockk<DataProductsState.Success>()
            val expected = mockk<ProductsState.Success>()
            every { cache.get() } returns dataState
            every { mapper.from(dataState) } returns expected

            // when
            val resultObserver = repository.getProductsState()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}
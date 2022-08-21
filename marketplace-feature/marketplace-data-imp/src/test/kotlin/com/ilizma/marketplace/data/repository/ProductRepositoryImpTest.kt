package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.datasource.ProductDataSource
import com.ilizma.marketplace.data.mapper.ProductsStateMapper
import com.ilizma.marketplace.domain.model.ProductsState
import com.ilizma.marketplace.domain.repository.ProductRepository
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
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
    private lateinit var mapper: ProductsStateMapper

    private lateinit var repository: ProductRepository

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        repository = ProductRepositoryImp(
            dataSource = dataSource,
            mapper = mapper,
        )
    }

    @Nested
    inner class GetProductsStateState {

        @Test
        fun `given DataProducts, when getPlayerName, then result should be the expected Products`() {
            // given
            val dataProducts = mockk<DataProductsState>()
            val expected = mockk<ProductsState>()
            every { dataSource.getProductsState() } returns Single.just(dataProducts)
            every { mapper.from(dataProducts) } returns expected

            // when
            val resultObserver = repository.getProductsState()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}
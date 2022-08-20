package com.ilizma.marketplace.data.repository

import com.ilizma.marketplace.data.datasource.ProductDataSource
import com.ilizma.marketplace.data.mapper.ProductsMapper
import com.ilizma.marketplace.domain.model.Products
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
import com.ilizma.marketplace.data.model.Products as DataProducts

internal class ProductRepositoryImpTest {

    @RelaxedMockK
    private lateinit var dataSource: ProductDataSource

    @RelaxedMockK
    private lateinit var mapper: ProductsMapper

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
    inner class GetProducts {

        @Test
        fun `given DataProducts, when getPlayerName, then result should be the expected Products`() {
            // given
            val dataProducts = mockk<DataProducts>()
            val expected = mockk<Products>()
            every { dataSource.getProducts() } returns Single.just(dataProducts)
            every { mapper.from(dataProducts) } returns expected

            // when
            val resultObserver = repository.getProducts()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}
package com.ilizma.marketplace.data.datasource

import com.ilizma.api.data.Api
import com.ilizma.api.model.ProductsDTO
import com.ilizma.marketplace.data.mapper.ProductsStateMapper
import com.ilizma.marketplace.data.model.ProductsState
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.RelaxedMockK
import io.mockk.mockk
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import retrofit2.adapter.rxjava3.Result

internal class ProductDataSourceImpTest {

    @RelaxedMockK
    private lateinit var api: Api

    @RelaxedMockK
    private lateinit var mapper: ProductsStateMapper

    private lateinit var dataSource: ProductDataSource

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        dataSource = ProductDataSourceImp(
            api = api,
            mapper = mapper,
        )
    }

    @Nested
    inner class GetProductsState {

        @Test
        fun `given Result ProductsDTO, when getProductsState, then result should be the expected ProductsState`() {
            // given
            val result = mockk<Result<ProductsDTO>>()
            val expected = mockk<ProductsState>()
            every { api.getProducts() } returns Single.just(result)
            every { mapper.from(result) } returns expected

            // when
            val resultObserver = dataSource.getProductsState()
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

}
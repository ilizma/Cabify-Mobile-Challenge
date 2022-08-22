package com.ilizma.marketplace.data.cache

import com.ilizma.marketplace.data.model.Product
import io.mockk.MockKAnnotations
import io.mockk.mockk
import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ProductCacheImpTest {

    private lateinit var cache: ProductCache

    init {
        MockKAnnotations.init(this)
    }

    private fun initCache(
        cacheMap: HashMap<Product, Int>,
    ) {
        cache = ProductCacheImp(
            cacheMap = cacheMap,
        )
    }

    @Nested
    inner class Get {

        @Test
        fun `given voucher, when get, then result should be the expected Int`() {
            // given
            val product = mockk<Product.Voucher>()
            val expected = 5
            initCache(hashMapOf(product to expected))

            // when
            val resultObserver = cache.get(product)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

        @Test
        fun `given tShirt, when get, then result should be the expected Int`() {
            // given
            val product = mockk<Product.TShirt>()
            val expected = 0
            initCache(hashMapOf(product to expected))

            // when
            val resultObserver = cache.get(product)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

        @Test
        fun `given mug, when get, then result should be the expected Int`() {
            // given
            val product = mockk<Product.Mug>()
            val expected = 3
            initCache(hashMapOf(product to expected))

            // when
            val resultObserver = cache.get(product)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

        @Test
        fun `given product with no hashMap, when get, then result should be the expected Int`() {
            // given
            val product = mockk<Product.Mug>()
            val expected = 0
            initCache(hashMapOf())

            // when
            val resultObserver = cache.get(product)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

    @Nested
    inner class Add {

        @Test
        fun `given product, when add, then result should be completed`() {
            // given
            val product = mockk<Product>()
            val value = 4
            initCache(hashMapOf(product to value))

            // when
            val resultObserver = cache.add(product)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertComplete()
        }

        @Test
        fun `given product with no hashMap, when add, then result should be completed`() {
            // given
            val product = mockk<Product.Voucher>()
            initCache(hashMapOf())

            // when
            val resultObserver = cache.add(product)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertComplete()
        }

    }

    @Nested
    inner class Remove {

        @Test
        fun `given product, when remove, then result should be completed`() {
            // given
            val product = mockk<Product>()
            val value = 4
            initCache(hashMapOf(product to value))

            // when
            val resultObserver = cache.remove(product)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertComplete()
        }

        @Test
        fun `given product with value 0, when remove, then result should be completed`() {
            // given
            val product = mockk<Product>()
            val value = 0
            initCache(hashMapOf(product to value))

            // when
            val resultObserver = cache.remove(product)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertComplete()
        }

        @Test
        fun `given Product with no hashMap, when remove, then result should be completed`() {
            // given
            val product = mockk<Product.Voucher>()
            initCache(hashMapOf())

            // when
            val resultObserver = cache.add(product)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertComplete()
        }

    }

}
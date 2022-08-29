package com.ilizma.marketplace.data.cache

import io.reactivex.rxjava3.schedulers.Schedulers
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test

internal class ProductQuantityCacheImpTest {

    private lateinit var cache: ProductQuantityCache

    private fun initCache(
        cacheMap: HashMap<String, Int>,
    ) {
        cache = ProductQuantityCacheImp(
            cacheMap = cacheMap,
        )
    }

    @Nested
    inner class Get {

        @Test
        fun `given productName, when get, then result should be the expected Int`() {
            // given
            val productName = "productName"
            val expected = 5
            initCache(hashMapOf(productName to expected))

            // when
            val resultObserver = cache.get(productName)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

        @Test
        fun `given productName with no hashMap, when get, then result should be the expected Int`() {
            // given
            val productName = "productName"
            val expected = 0
            initCache(hashMapOf())

            // when
            val resultObserver = cache.get(productName)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertValue { it == expected }
        }

    }

    @Nested
    inner class Add {

        @Test
        fun `given productName, when add, then result should be completed`() {
            // given
            val productName = "productName"
            val value = 4
            initCache(hashMapOf(productName to value))

            // when
            val resultObserver = cache.add(productName)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertComplete()
        }

        @Test
        fun `given productName with no hashMap, when add, then result should be completed`() {
            // given
            val productName = "productName"
            initCache(hashMapOf())

            // when
            val resultObserver = cache.add(productName)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertComplete()
        }

    }

    @Nested
    inner class Remove {

        @Test
        fun `given productName, when remove, then result should be completed`() {
            // given
            val productName = "productName"
            val value = 4
            initCache(hashMapOf(productName to value))

            // when
            val resultObserver = cache.remove(productName)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertComplete()
        }

        @Test
        fun `given productName with value 0, when remove, then result should be completed`() {
            // given
            val productName = "productName"
            val value = 0
            initCache(hashMapOf(productName to value))

            // when
            val resultObserver = cache.remove(productName)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertComplete()
        }

        @Test
        fun `given productName with no hashMap, when remove, then result should be completed`() {
            // given
            val productName = "productName"
            initCache(hashMapOf())

            // when
            val resultObserver = cache.add(productName)
                .observeOn(Schedulers.trampoline())
                .test()

            // then
            resultObserver.assertComplete()
        }

    }

}
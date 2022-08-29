package com.ilizma.marketplace.domain.mapper

import com.ilizma.marketplace.domain.model.ArticleCheckoutInfo
import com.ilizma.marketplace.domain.model.DiscountData
import com.ilizma.marketplace.domain.model.DiscountDataList
import com.ilizma.marketplace.domain.model.Product
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.mockk
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.util.*

internal class ArticleCheckoutInfoMapperTest {

    private lateinit var mapper: ArticleCheckoutInfoMapper
    private val currencySymbolText = "%s€"
    private val promotionText = "buy %s of the same product, get %s free"

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = ArticleCheckoutInfoMapper(
            locale = Locale.ENGLISH,
            currencySymbolText = currencySymbolText,
            promotionText = promotionText,
        )
    }

    @Nested
    inner class From {

        @Test
        fun `given Mug Product and quantity list with 1, when from, then result should be the expected Mug ArticleCheckoutInfo`() {
            // given
            val name = "name"
            val price = 19f
            val priceWithSymbol = "19.00€"
            val quantity = 1
            val product = mockk<Product.Mug>()
            val productQuantityList = listOf<Pair<Product, Int>>(product to quantity)
            val discountDataList = mockk<DiscountDataList>()
            val expected = ArticleCheckoutInfo.Mug(
                name = name,
                quantity = quantity,
                priceWithSymbol = priceWithSymbol,
                totalPrice = price,
            )
            every { product.name } returns name
            every { product.price } returns price
            every { product.priceWithSymbol } returns priceWithSymbol

            // when
            val result = mapper.from(product, productQuantityList, discountDataList)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Mug Product and empty quantity list, when from, then result should be the expected Mug ArticleCheckoutInfo`() {
            // given
            val name = "name"
            val price = 19f
            val priceWithSymbol = "19.00€"
            val quantity = 0
            val product = mockk<Product.Mug>()
            val productQuantityList = listOf<Pair<Product, Int>>()
            val discountDataList = mockk<DiscountDataList>()
            val expected = ArticleCheckoutInfo.Mug(
                name = name,
                quantity = quantity,
                priceWithSymbol = priceWithSymbol,
                totalPrice = 0f,
            )
            every { product.name } returns name
            every { product.price } returns price
            every { product.priceWithSymbol } returns priceWithSymbol

            // when
            val result = mapper.from(product, productQuantityList, discountDataList)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt Product and quantity list with 1, when from, then result should be the expected TShirt ArticleCheckoutInfo`() {
            // given
            val name = "name"
            val price = 20f
            val priceWithSymbol = "19.00€"
            val offer = 19
            val quantity = 1
            val bulkQuantity = 3
            val product = mockk<Product.TShirt>()
            val productQuantityList = listOf<Pair<Product, Int>>(product to quantity)
            val discountData = mockk<DiscountData.Bulk>()
            val discountDataList = mockk<DiscountDataList>()
            val expected = ArticleCheckoutInfo.TShirt(
                name = name,
                quantity = quantity,
                priceWithSymbol = priceWithSymbol,
                totalPrice = price,
                oldPrice = "",
            )
            every { product.name } returns name
            every { product.price } returns price
            every { product.priceWithSymbol } returns priceWithSymbol
            every { discountDataList.list } returns listOf(discountData)
            every { discountData.offer } returns offer
            every { discountData.quantity } returns bulkQuantity

            // when
            val result = mapper.from(product, productQuantityList, discountDataList)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt Product and quantity list with 3, when from, then result should be the expected TShirt ArticleCheckoutInfo`() {
            // given
            val name = "name"
            val price = 20f
            val priceWithSymbol = "20.00€"
            val offer = 19
            val quantity = 3
            val bulkQuantity = 3
            val product = mockk<Product.TShirt>()
            val productQuantityList = listOf<Pair<Product, Int>>(product to quantity)
            val discountData = mockk<DiscountData.Bulk>()
            val discountDataList = mockk<DiscountDataList>()
            val expected = ArticleCheckoutInfo.TShirt(
                name = name,
                quantity = quantity,
                priceWithSymbol = "$offer.00€",
                totalPrice = 57f,
                oldPrice = priceWithSymbol,
            )
            every { product.name } returns name
            every { product.price } returns price
            every { product.priceWithSymbol } returns priceWithSymbol
            every { discountDataList.list } returns listOf(discountData)
            every { discountData.offer } returns offer
            every { discountData.quantity } returns bulkQuantity

            // when
            val result = mapper.from(product, productQuantityList, discountDataList)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt Product and empty quantity list, when from, then result should be the expected TShirt ArticleCheckoutInfo`() {
            // given
            val name = "name"
            val price = 20f
            val priceWithSymbol = "20.00€"
            val offer = 19
            val quantity = 0
            val bulkQuantity = 3
            val product = mockk<Product.TShirt>()
            val productQuantityList = listOf<Pair<Product, Int>>()
            val discountData = mockk<DiscountData.Bulk>()
            val discountDataList = mockk<DiscountDataList>()
            val expected = ArticleCheckoutInfo.TShirt(
                name = name,
                quantity = quantity,
                priceWithSymbol = priceWithSymbol,
                totalPrice = 0f,
                oldPrice = "",
            )
            every { product.name } returns name
            every { product.price } returns price
            every { product.priceWithSymbol } returns priceWithSymbol
            every { discountDataList.list } returns listOf(discountData)
            every { discountData.offer } returns offer
            every { discountData.quantity } returns bulkQuantity

            // when
            val result = mapper.from(product, productQuantityList, discountDataList)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Voucher Product and quantity list with 1, when from, then result should be the expected Voucher ArticleCheckoutInfo`() {
            // given
            val name = "name"
            val price = 5f
            val priceWithSymbol = "5.00€"
            val discountQuantity = 2
            val offer = 1
            val quantity = 1
            val product = mockk<Product.Voucher>()
            val productQuantityList = listOf<Pair<Product, Int>>(product to quantity)
            val discountData = mockk<DiscountData.Promotion>()
            val discountDataList = mockk<DiscountDataList>()
            val expected = ArticleCheckoutInfo.Voucher(
                name = name,
                quantity = quantity,
                priceWithSymbol = priceWithSymbol,
                totalPrice = price,
                promotion = "buy $discountQuantity of the same product, get $offer free",
            )
            every { product.name } returns name
            every { product.price } returns price
            every { product.priceWithSymbol } returns priceWithSymbol
            every { discountDataList.list } returns listOf(discountData)
            every { discountData.quantity } returns discountQuantity
            every { discountData.offer } returns offer

            // when
            val result = mapper.from(product, productQuantityList, discountDataList)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Voucher Product and quantity list with 5, when from, then result should be the expected Voucher ArticleCheckoutInfo`() {
            // given
            val name = "name"
            val price = 5f
            val priceWithSymbol = "5.00€"
            val discountQuantity = 2
            val offer = 1
            val quantity = 5
            val product = mockk<Product.Voucher>()
            val productQuantityList = listOf<Pair<Product, Int>>(product to quantity)
            val discountData = mockk<DiscountData.Promotion>()
            val discountDataList = mockk<DiscountDataList>()
            val expected = ArticleCheckoutInfo.Voucher(
                name = name,
                quantity = quantity,
                priceWithSymbol = priceWithSymbol,
                totalPrice = 15f,
                promotion = "buy $discountQuantity of the same product, get $offer free",
            )
            every { product.name } returns name
            every { product.price } returns price
            every { product.priceWithSymbol } returns priceWithSymbol
            every { discountDataList.list } returns listOf(discountData)
            every { discountData.quantity } returns discountQuantity
            every { discountData.offer } returns offer

            // when
            val result = mapper.from(product, productQuantityList, discountDataList)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Voucher Product and empty quantity list, when from, then result should be the expected Voucher ArticleCheckoutInfo`() {
            // given
            val name = "name"
            val price = 5f
            val priceWithSymbol = "5.00€"
            val discountQuantity = 2
            val offer = 1
            val quantity = 0
            val product = mockk<Product.Voucher>()
            val productQuantityList = listOf<Pair<Product, Int>>()
            val discountData = mockk<DiscountData.Promotion>()
            val discountDataList = mockk<DiscountDataList>()
            val expected = ArticleCheckoutInfo.Voucher(
                name = name,
                quantity = quantity,
                priceWithSymbol = priceWithSymbol,
                totalPrice = 0f,
                promotion = "buy $discountQuantity of the same product, get $offer free",
            )
            every { product.name } returns name
            every { product.price } returns price
            every { product.priceWithSymbol } returns priceWithSymbol
            every { discountDataList.list } returns listOf(discountData)
            every { discountData.quantity } returns discountQuantity
            every { discountData.offer } returns offer

            // when
            val result = mapper.from(product, productQuantityList, discountDataList)

            // then
            assertEquals(expected, result)
        }

    }

}
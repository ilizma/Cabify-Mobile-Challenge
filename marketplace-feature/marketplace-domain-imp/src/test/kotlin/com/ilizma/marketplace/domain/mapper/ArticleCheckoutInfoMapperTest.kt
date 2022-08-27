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
    private val moneyText = "%s€"
    private val promotionText = "buy %s of the same product, get %s free"

    init {
        MockKAnnotations.init(this)
    }

    @BeforeEach
    private fun setup() {
        mapper = ArticleCheckoutInfoMapper(
            locale = Locale.ENGLISH,
            moneyText = moneyText,
            promotionText = promotionText,
        )
    }

    @Nested
    inner class From {

        @Test
        fun `given Mug Product and quantity list with 1, when from, then result should be the expected Mug ArticleCheckoutInfo`() {
            // given
            val name = "name"
            val price = "price"
            val quantity = 1
            val product = mockk<Product.Mug>()
            val productQuantityList = listOf<Pair<Product, Int>>(product to quantity)
            val discountDataList = mockk<DiscountDataList>()
            val expected = ArticleCheckoutInfo.Mug(name = name, quantity = quantity, price = price)
            every { product.name } returns name
            every { product.price } returns price

            // when
            val result = mapper.from(product, productQuantityList, discountDataList)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Mug Product and empty quantity list, when from, then result should be the expected Mug ArticleCheckoutInfo`() {
            // given
            val name = "name"
            val price = "price"
            val quantity = 0
            val product = mockk<Product.Mug>()
            val productQuantityList = listOf<Pair<Product, Int>>()
            val discountDataList = mockk<DiscountDataList>()
            val expected = ArticleCheckoutInfo.Mug(name = name, quantity = quantity, price = price)
            every { product.name } returns name
            every { product.price } returns price

            // when
            val result = mapper.from(product, productQuantityList, discountDataList)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt Product and quantity list with 1, when from, then result should be the expected TShirt ArticleCheckoutInfo`() {
            // given
            val name = "name"
            val price = "price"
            val offer = 19
            val quantity = 1
            val product = mockk<Product.TShirt>()
            val productQuantityList = listOf<Pair<Product, Int>>(product to quantity)
            val discountData = mockk<DiscountData.Bulk>()
            val discountDataList = mockk<DiscountDataList>()
            val expected = ArticleCheckoutInfo.TShirt(name = name,
                quantity = quantity,
                price = price,
                oldPrice = "$offer.00€",
            )
            every { product.name } returns name
            every { product.price } returns price
            every { discountDataList.list } returns listOf(discountData)
            every { discountData.offer } returns offer

            // when
            val result = mapper.from(product, productQuantityList, discountDataList)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given TShirt Product and empty quantity list, when from, then result should be the expected TShirt ArticleCheckoutInfo`() {
            // given
            val name = "name"
            val price = "price"
            val offer = 19
            val quantity = 0
            val product = mockk<Product.TShirt>()
            val productQuantityList = listOf<Pair<Product, Int>>()
            val discountData = mockk<DiscountData.Bulk>()
            val discountDataList = mockk<DiscountDataList>()
            val expected = ArticleCheckoutInfo.TShirt(name = name,
                quantity = quantity,
                price = price,
                oldPrice = "$offer.00€",
            )
            every { product.name } returns name
            every { product.price } returns price
            every { discountDataList.list } returns listOf(discountData)
            every { discountData.offer } returns offer

            // when
            val result = mapper.from(product, productQuantityList, discountDataList)

            // then
            assertEquals(expected, result)
        }

        @Test
        fun `given Voucher Product and quantity list with 1, when from, then result should be the expected Voucher ArticleCheckoutInfo`() {
            // given
            val name = "name"
            val price = "price"
            val discountQuantity = 2
            val offer = 1
            val quantity = 1
            val product = mockk<Product.Voucher>()
            val productQuantityList = listOf<Pair<Product, Int>>(product to quantity)
            val discountData = mockk<DiscountData.Promotion>()
            val discountDataList = mockk<DiscountDataList>()
            val expected = ArticleCheckoutInfo.Voucher(name = name,
                quantity = quantity,
                price = price,
                promotion = "buy $discountQuantity of the same product, get $offer free",
            )
            every { product.name } returns name
            every { product.price } returns price
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
            val price = "price"
            val discountQuantity = 2
            val offer = 1
            val quantity = 0
            val product = mockk<Product.Voucher>()
            val productQuantityList = listOf<Pair<Product, Int>>()
            val discountData = mockk<DiscountData.Promotion>()
            val discountDataList = mockk<DiscountDataList>()
            val expected = ArticleCheckoutInfo.Voucher(name = name,
                quantity = quantity,
                price = price,
                promotion = "buy $discountQuantity of the same product, get $offer free",
            )
            every { product.name } returns name
            every { product.price } returns price
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
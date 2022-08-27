package com.ilizma.marketplace.domain.mapper

import com.ilizma.marketplace.domain.model.ArticleCheckoutInfo
import com.ilizma.marketplace.domain.model.DiscountData
import com.ilizma.marketplace.domain.model.DiscountDataList
import com.ilizma.marketplace.domain.model.Product
import java.util.*

private const val TWO_DECIMAL_FORMAT = "%.2f"

class ArticleCheckoutInfoMapper(
    private val locale: Locale,
    private val moneyText: String,
    private val promotionText: String,
) {

    fun from(
        product: Product,
        productQuantityList: List<Pair<Product, Int>>,
        discounts: DiscountDataList,
    ): ArticleCheckoutInfo = when (product) {
        is Product.Mug -> ArticleCheckoutInfo.Mug(
            name = product.name,
            quantity = productQuantityList.firstOrNull { it.first == product }?.second ?: 0,
            price = product.price,
        )
        is Product.TShirt -> ArticleCheckoutInfo.TShirt(
            name = product.name,
            quantity = productQuantityList.firstOrNull { it.first == product }?.second ?: 0,
            price = product.price,
            oldPrice = discounts.list.first { it is DiscountData.Bulk }
                .let { String.format(locale, TWO_DECIMAL_FORMAT, it.offer.toFloat()) }
                .let { moneyText.format(it) },
        )
        is Product.Voucher -> ArticleCheckoutInfo.Voucher(
            name = product.name,
            quantity = productQuantityList.firstOrNull { it.first == product }?.second ?: 0,
            price = product.price,
            promotion = discounts.list.first { it is DiscountData.Promotion }
                .let { promotionText.format(it.quantity, it.offer) }
        )
    }

}
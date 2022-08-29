package com.ilizma.marketplace.domain.mapper

import com.ilizma.marketplace.domain.model.ArticleCheckoutInfo
import com.ilizma.marketplace.domain.model.DiscountData
import com.ilizma.marketplace.domain.model.DiscountDataList
import com.ilizma.marketplace.domain.model.Product
import java.util.*
import kotlin.math.ceil

private const val TWO_DECIMAL_FORMAT = "%.2f"

class ArticleCheckoutInfoMapper(
    private val locale: Locale,
    private val currencySymbolText: String,
    private val promotionText: String,
) {

    fun from(
        product: Product,
        productQuantityList: List<Pair<Product, Int>>,
        discounts: DiscountDataList,
    ): ArticleCheckoutInfo = when (product) {
        is Product.Mug -> (productQuantityList.firstOrNull { it.first == product }?.second ?: 0)
            .let { quantity ->
                ArticleCheckoutInfo.Mug(
                    name = product.name,
                    quantity = quantity,
                    priceWithSymbol = product.priceWithSymbol,
                    totalPrice = product.price * quantity
                )
            }
        is Product.TShirt -> (productQuantityList.firstOrNull { it.first == product }?.second ?: 0)
            .let { quantity ->
                discounts.list.first { it is DiscountData.Bulk }
                    .let { discountData ->
                        ArticleCheckoutInfo.TShirt(
                            name = product.name,
                            quantity = quantity,
                            priceWithSymbol = if (moreThanDiscountQuantity(quantity, discountData)) {
                                String.format(locale, TWO_DECIMAL_FORMAT, discountData.offer.toFloat())
                                    .let { currencySymbolText.format(it) }
                            } else {
                                product.priceWithSymbol
                            },
                            totalPrice = if (moreThanDiscountQuantity(quantity, discountData)) {
                                discountData.offer.toFloat()
                            } else {
                                product.price
                            }.let { it * quantity },
                            oldPrice = if (moreThanDiscountQuantity(quantity, discountData)) product.priceWithSymbol else "",
                        )
                    }
            }
        is Product.Voucher -> (productQuantityList.firstOrNull { it.first == product }?.second ?: 0)
            .let { quantity ->
                discounts.list.first { it is DiscountData.Promotion }
                    .let { discountData ->
                        ArticleCheckoutInfo.Voucher(
                            name = product.name,
                            quantity = quantity,
                            priceWithSymbol = product.priceWithSymbol,
                            totalPrice = if (moreThanDiscountQuantity(quantity, discountData)) {
                                ceil(quantity.toDouble() / discountData.quantity).toInt() * discountData.offer
                            } else {
                                quantity
                            }.let { it * product.price },
                            promotion = promotionText.format(discountData.quantity, discountData.offer)
                        )
                    }
            }

    }

    private fun moreThanDiscountQuantity(
        quantity: Int,
        discountData: DiscountData,
    ): Boolean = quantity >= discountData.quantity

}
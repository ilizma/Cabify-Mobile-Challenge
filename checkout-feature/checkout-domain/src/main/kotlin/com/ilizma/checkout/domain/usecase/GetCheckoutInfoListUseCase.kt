package com.ilizma.checkout.domain.usecase

import com.ilizma.checkout.domain.model.CheckoutInfoList
import io.reactivex.rxjava3.core.Single

interface GetCheckoutInfoListUseCase {

    operator fun invoke(): Single<CheckoutInfoList>

}
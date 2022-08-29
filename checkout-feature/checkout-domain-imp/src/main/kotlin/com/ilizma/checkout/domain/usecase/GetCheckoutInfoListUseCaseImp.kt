package com.ilizma.checkout.domain.usecase

import com.ilizma.checkout.domain.model.CheckoutInfoList
import com.ilizma.checkout.domain.repository.CheckoutRepository
import io.reactivex.rxjava3.core.Single

class GetCheckoutInfoListUseCaseImp(
    private val repository: CheckoutRepository,
) : GetCheckoutInfoListUseCase {

    override fun invoke(
    ): Single<CheckoutInfoList> = repository.getCheckoutInfoList()

}
package com.ilizma.checkout.domain.usecase

import com.ilizma.checkout.domain.repository.CheckoutRepository
import io.reactivex.rxjava3.core.Single

class GetTotalUseCaseImp(
    private val repository: CheckoutRepository,
) : GetTotalUseCase {

    override fun invoke(
    ): Single<String> = repository.getTotal()

}
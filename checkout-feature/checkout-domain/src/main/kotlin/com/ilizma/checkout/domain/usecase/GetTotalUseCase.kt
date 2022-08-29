package com.ilizma.checkout.domain.usecase

import io.reactivex.rxjava3.core.Single

interface GetTotalUseCase {

    operator fun invoke(): Single<String>

}
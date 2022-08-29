package com.ilizma.marketplace.domain.usecase

import io.reactivex.rxjava3.core.Single

interface GetArticleQuantityUseCase {

    operator fun invoke(articleName: String): Single<Int>

}
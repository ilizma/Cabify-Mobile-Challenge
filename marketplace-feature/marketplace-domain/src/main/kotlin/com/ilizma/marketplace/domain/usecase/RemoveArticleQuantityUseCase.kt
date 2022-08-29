package com.ilizma.marketplace.domain.usecase

import io.reactivex.rxjava3.core.Completable

interface RemoveArticleQuantityUseCase {

    operator fun invoke(articleName: String): Completable

}
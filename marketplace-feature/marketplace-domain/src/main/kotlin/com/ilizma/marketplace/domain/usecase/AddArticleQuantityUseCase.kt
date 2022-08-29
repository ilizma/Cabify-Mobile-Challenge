package com.ilizma.marketplace.domain.usecase

import io.reactivex.rxjava3.core.Completable

interface AddArticleQuantityUseCase {

    operator fun invoke(articleName: String): Completable

}
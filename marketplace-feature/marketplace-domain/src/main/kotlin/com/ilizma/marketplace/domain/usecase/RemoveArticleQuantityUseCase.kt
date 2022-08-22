package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.model.Article
import io.reactivex.rxjava3.core.Completable

interface RemoveArticleQuantityUseCase {

    operator fun invoke(article: Article): Completable

}
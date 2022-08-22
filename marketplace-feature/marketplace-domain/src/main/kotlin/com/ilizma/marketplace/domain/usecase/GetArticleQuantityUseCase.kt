package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.model.Article
import io.reactivex.rxjava3.core.Single

interface GetArticleQuantityUseCase {

    operator fun invoke(article: Article): Single<Int>

}
package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.model.ArticlesState
import io.reactivex.rxjava3.core.Single

interface GetArticlesStateUseCase {

    operator fun invoke(): Single<ArticlesState>

}
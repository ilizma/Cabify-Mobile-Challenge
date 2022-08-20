package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.model.Articles
import io.reactivex.rxjava3.core.Single

interface GetArticlesUseCase {

    operator fun invoke(): Single<Articles>

}
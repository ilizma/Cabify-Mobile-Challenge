package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.model.ArticlesCheckoutInfo
import io.reactivex.rxjava3.core.Single

interface GetArticlesCheckoutInfoUseCase {

    operator fun invoke(): Single<ArticlesCheckoutInfo>

}
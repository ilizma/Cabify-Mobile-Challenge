package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.repository.ArticleRepository
import io.reactivex.rxjava3.core.Single

class GetArticleQuantityUseCaseImp(
    private val repository: ArticleRepository,
) : GetArticleQuantityUseCase {

    override fun invoke(
        articleName: String,
    ): Single<Int> = repository.getQuantity(articleName)

}
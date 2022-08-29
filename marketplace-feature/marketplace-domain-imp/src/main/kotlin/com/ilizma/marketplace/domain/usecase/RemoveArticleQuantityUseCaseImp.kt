package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.repository.ArticleRepository
import io.reactivex.rxjava3.core.Completable

class RemoveArticleQuantityUseCaseImp(
    private val repository: ArticleRepository,
) : RemoveArticleQuantityUseCase {

    override fun invoke(
        articleName: String,
    ): Completable = repository.removeQuantity(articleName)

}
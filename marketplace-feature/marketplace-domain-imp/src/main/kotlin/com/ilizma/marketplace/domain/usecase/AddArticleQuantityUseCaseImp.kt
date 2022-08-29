package com.ilizma.marketplace.domain.usecase

import com.ilizma.marketplace.domain.repository.ArticleRepository
import io.reactivex.rxjava3.core.Completable

class AddArticleQuantityUseCaseImp(
    private val repository: ArticleRepository,
) : AddArticleQuantityUseCase {

    override fun invoke(
        articleName: String,
    ): Completable = repository.addQuantity(articleName)

}
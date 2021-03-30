package com.igorwojda.showcase.feature.explore.data.repository

import com.igorwojda.showcase.feature.explore.data.model.toDomainModel
import com.igorwojda.showcase.feature.explore.data.retrofit.service.ExploreRetrofitService
import com.igorwojda.showcase.feature.explore.domain.repository.ExploreRepository

internal class ExploreRepositoryImpl(
    private val albumRetrofitService: ExploreRetrofitService
) : ExploreRepository {

    override suspend fun searchAlbum(phrase: String) =
        albumRetrofitService.searchAlbumAsync(phrase)
            .results
            .exploreMatches
            .album
            .map { it.toDomainModel() }
}

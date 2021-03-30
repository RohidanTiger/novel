package com.igorwojda.showcase.feature.explore.domain.repository

import com.igorwojda.showcase.feature.explore.domain.model.ExploreDomainModel

internal interface ExploreRepository {

    suspend fun searchAlbum(phrase: String): List<ExploreDomainModel>
}

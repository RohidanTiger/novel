package com.igorwojda.showcase.feature.explore.data.model

import com.igorwojda.showcase.feature.explore.domain.model.ExploreWikiDomainModel

internal data class ExploreWikiDataModel(
    val published: String,
    val summary: String
)

internal fun ExploreWikiDataModel.toDomainModel() = ExploreWikiDomainModel(
    published = this.published,
    summary = this.summary
)

package com.igorwojda.showcase.feature.explore.data.model

import com.squareup.moshi.Json

internal data class ExploreSearchResultDataModel(
    @field:Json(name = "albummatches") val exploreMatches: ExploreListDataModel
)

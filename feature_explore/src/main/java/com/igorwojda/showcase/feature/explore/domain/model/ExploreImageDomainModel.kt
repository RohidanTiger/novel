package com.igorwojda.showcase.feature.explore.domain.model

import com.igorwojda.showcase.feature.explore.domain.enum.ExploreDomainImageSize

internal data class ExploreImageDomainModel(
    val url: String,
    val size: ExploreDomainImageSize
)

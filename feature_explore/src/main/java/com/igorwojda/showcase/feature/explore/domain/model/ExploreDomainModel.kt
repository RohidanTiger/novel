package com.igorwojda.showcase.feature.explore.domain.model

import com.igorwojda.showcase.feature.explore.domain.enum.ExploreDomainImageSize

internal data class ExploreDomainModel(
    val name: String,
    val artist: String,
    val images: List<ExploreImageDomainModel>,
    val wiki: ExploreWikiDomainModel? = null,
    val mbId: String? = null
) {
    fun getDefaultImageUrl() = images.firstOrNull { it.size == ExploreDomainImageSize.EXTRA_LARGE }?.url
}

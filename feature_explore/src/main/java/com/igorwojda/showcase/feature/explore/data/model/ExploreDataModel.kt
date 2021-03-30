package com.igorwojda.showcase.feature.explore.data.model

import com.igorwojda.showcase.feature.explore.data.enum.ExploreDataImageSize
import com.igorwojda.showcase.feature.explore.domain.model.ExploreDomainModel
import com.squareup.moshi.Json

internal data class ExploreDataModel(
    @field:Json(name = "mbid") val mbId: String?,
    val name: String,
    val artist: String,
    val wiki: ExploreWikiDataModel?,
    @field:Json(name = "image") val images: List<ExploreImageDataModel>?
)

internal fun ExploreDataModel.toDomainModel(): ExploreDomainModel {
    val images = this.images
        ?.filterNot { it.size == ExploreDataImageSize.UNKNOWN || it.url.isBlank() }
        ?.map { it.toDomainModel() }

    return ExploreDomainModel(
        mbId = this.mbId,
        name = this.name,
        artist = this.artist,
        images = images ?: listOf(),
        wiki = this.wiki?.toDomainModel()
    )
}

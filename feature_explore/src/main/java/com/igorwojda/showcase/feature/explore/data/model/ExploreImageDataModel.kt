package com.igorwojda.showcase.feature.explore.data.model

import com.igorwojda.showcase.feature.explore.data.enum.ExploreDataImageSize
import com.igorwojda.showcase.feature.explore.data.enum.toDomainEnum
import com.igorwojda.showcase.feature.explore.domain.model.ExploreImageDomainModel
import com.squareup.moshi.Json

internal data class ExploreImageDataModel(
    @field:Json(name = "#text") val url: String,
    val size: ExploreDataImageSize
)


internal fun ExploreImageDataModel.toDomainModel() = ExploreImageDomainModel(
    url = this.url,
    size = this.size.toDomainEnum()
)

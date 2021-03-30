package com.igorwojda.showcase.feature.explore.data.enum

import com.igorwojda.showcase.feature.explore.domain.enum.ExploreDomainImageSize
import com.squareup.moshi.Json

internal enum class ExploreDataImageSize {

    @field:Json(name = "medium")
    MEDIUM,
    @field:Json(name = "small")
    SMALL,
    @field:Json(name = "large")
    LARGE,
    @field:Json(name = "extralarge")
    EXTRA_LARGE,
    @field:Json(name = "mega")
    MEGA,
    @field:Json(name = "")
    UNKNOWN
}

internal fun ExploreDataImageSize.toDomainEnum() = ExploreDomainImageSize.valueOf(this.name)

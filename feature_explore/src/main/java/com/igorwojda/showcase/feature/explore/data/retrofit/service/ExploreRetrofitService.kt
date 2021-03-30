package com.igorwojda.showcase.feature.explore.data.retrofit.service

import com.igorwojda.showcase.feature.explore.data.retrofit.response.SearchAlbumResponse
import retrofit2.http.POST
import retrofit2.http.Query

internal interface ExploreRetrofitService {

    @POST("./?method=album.search")
    suspend fun searchAlbumAsync(
        @Query("album") phrase: String,
        @Query("limit") limit: Int = 60
    ): SearchAlbumResponse
}

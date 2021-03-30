package com.igorwojda.showcase.feature.explore.domain.usecase

import com.igorwojda.showcase.feature.explore.domain.model.ExploreDomainModel
import com.igorwojda.showcase.feature.explore.domain.repository.ExploreRepository
import java.io.IOException

internal class GetAlbumListUseCase(
    private val albumRepository: ExploreRepository
) {

    sealed class Result {
        data class Success(val data: List<ExploreDomainModel>) : Result()
        data class Error(val e: Throwable) : Result()
    }

    suspend fun execute(): Result {
        // Due to API limitations we have to perform search with custom phrase to get albums
        val phrase = "sd"

        return try {
            Result.Success(albumRepository.searchAlbum(phrase)
                .filter { it.getDefaultImageUrl() != null }
            )
        } catch (e: IOException) {
            Result.Error(e)
        }
    }
}

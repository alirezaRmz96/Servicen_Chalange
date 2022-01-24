package com.example.firstjetchalange.domain.usecase

import com.example.firstjetchalange.data.models.albumId.AlbumIdList
import com.example.firstjetchalange.domain.repository.AlbumIdRepository

class GetAlbumIdUseCase(private val albumIdRepository: AlbumIdRepository) {
    suspend fun execute():List<AlbumIdList>? = albumIdRepository.getAlbumId()
}
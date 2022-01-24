package com.example.firstjetchalange.domain.repository

import com.example.firstjetchalange.data.models.albumId.AlbumIdList

interface AlbumIdRepository {
    suspend fun getAlbumId():List<AlbumIdList>?
}
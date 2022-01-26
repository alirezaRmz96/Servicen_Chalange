package com.example.firstjetchalange.data.repository.albumId

import com.example.firstjetchalange.data.models.albumId.AlbumIdList
import retrofit2.Response

interface AlbumIdRemoteDataSource {
    suspend fun getAlbumId():Response<AlbumIdList>
}
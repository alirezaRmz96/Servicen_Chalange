package com.example.firstjetchalange.data.repository.albumId

import com.example.firstjetchalange.data.api.ApiService
import com.example.firstjetchalange.data.models.albumId.AlbumIdList
import retrofit2.Response

class AlbumIdRemoteDataSourceImpl (
    private val apiService: ApiService
    ):AlbumIdRemoteDataSource {
    override suspend fun getAlbumId():
            Response<AlbumIdList> = apiService.getAlbumId()
}
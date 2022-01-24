package com.example.firstjetchalange.data.repository.albumId

import android.util.Log
import com.example.firstjetchalange.data.models.albumId.AlbumIdList
import com.example.firstjetchalange.domain.repository.AlbumIdRepository
import java.lang.Exception

class AlbumIdRepositoryImpl(
    private val albumIdRemoteDataSource: AlbumIdRemoteDataSource
    ):AlbumIdRepository {
    override suspend fun getAlbumId(): List<AlbumIdList>? {
        return getAlbumIdFromApi()
    }

    suspend fun getAlbumIdFromApi():List<AlbumIdList>{
        lateinit var albumidlist:List<AlbumIdList>
        try {
            val response = albumIdRemoteDataSource.getAlbumId()
            val body = response.body()
            if (body!!.isNotEmpty()){
                albumidlist = listOf(body)
            }
        }catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return albumidlist
    }
}
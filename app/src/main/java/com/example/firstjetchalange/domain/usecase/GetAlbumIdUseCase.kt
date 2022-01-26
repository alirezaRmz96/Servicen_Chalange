package com.example.firstjetchalange.domain.usecase

import com.example.firstjetchalange.data.models.albumId.AlbumIdList
import com.example.firstjetchalange.data.models.albumId.AlbumIdListItem
import com.example.firstjetchalange.domain.repository.AlbumIdRepository

class GetAlbumIdUseCase(private val albumIdRepository: AlbumIdRepository) {
    var listAlbumId = mutableListOf<AlbumIdListItem>()
    suspend fun execute() {
        listAlbumId.clear()
        albumIdRepository.getAlbumId()?.let {
            listAlbumId.addAll(it[0])
        }
    }

    suspend fun getAlbumId(userID:Int):List<AlbumIdListItem>{
        val specialList = mutableListOf<AlbumIdListItem>()
        listAlbumId.map {
            if (it.albumId == userID){
                specialList.add(it)
            }
        }
        return specialList
//        listAlbumId.filter {
//
//        }
    }

}
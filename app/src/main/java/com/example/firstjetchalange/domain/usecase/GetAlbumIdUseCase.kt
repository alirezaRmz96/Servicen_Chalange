package com.example.firstjetchalange.domain.usecase

import com.example.firstjetchalange.data.models.albumId.AlbumIdList
import com.example.firstjetchalange.data.models.albumId.AlbumIdListItem
import com.example.firstjetchalange.data.models.userInfo.UserInfoList
import com.example.firstjetchalange.domain.repository.AlbumIdRepository

class GetAlbumIdUseCase(private val albumIdRepository: AlbumIdRepository) {
    var listAlbumId = mutableListOf<AlbumIdListItem>()

    suspend fun mapAlbumId(userID:Int):List<AlbumIdListItem>{
        albumIdRepository.getAlbumId()?.let {
            listAlbumId.addAll(it[0])
        }
        val specialList = mutableListOf<AlbumIdListItem>()
        listAlbumId.map {
            if (it.albumId == userID){
                specialList.add(it)
            }
        }
        return specialList
    }


}





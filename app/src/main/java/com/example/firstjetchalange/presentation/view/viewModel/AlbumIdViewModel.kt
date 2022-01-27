package com.example.firstjetchalange.presentation.view.viewModel

import androidx.lifecycle.*
import com.example.firstjetchalange.data.models.albumId.AlbumIdList
import com.example.firstjetchalange.domain.usecase.GetAlbumIdUseCase

class AlbumIdViewModel(
    private val getAlbumIdUseCase: GetAlbumIdUseCase
) : ViewModel(){

    fun getAlbumId (userId:Int) = liveData {
        //val albumIdList = getAlbumIdUseCase.execute()
        val albumIdResult = getAlbumIdUseCase.mapAlbumId(userId)
        emit(albumIdResult)

    }
}
class AlbumIdViewModelFactory(
    private val getAlbumIdUseCase: GetAlbumIdUseCase
    ):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AlbumIdViewModel(getAlbumIdUseCase) as T
    }

}
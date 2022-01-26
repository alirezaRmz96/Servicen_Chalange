package com.example.firstjetchalange.presentation.view.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.firstjetchalange.domain.usecase.GetAlbumIdUseCase

class AlbumIdViewModel(
    private val getAlbumIdUseCase: GetAlbumIdUseCase
) : ViewModel(){

    fun getAlbumId (userId:Int) = liveData {
        val albumIdList =  getAlbumIdUseCase.execute()
        val albumIdResult = getAlbumIdUseCase.getAlbumId(userId)
        emit(albumIdResult)
    }


//    fun getAlbumId1() = MutableLiveData{
//        //val album
//    }
}
class AlbumIdViewModelFactory(
    private val getAlbumIdUseCase: GetAlbumIdUseCase
    ):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AlbumIdViewModel(getAlbumIdUseCase) as T
    }

}
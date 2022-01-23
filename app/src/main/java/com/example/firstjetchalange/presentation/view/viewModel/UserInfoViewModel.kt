package com.example.firstjetchalange.presentation.view.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.firstjetchalange.domain.usecase.GetUserInfoUseCase

class UserInfoViewModel(
    private val getUserInfoUseCase: GetUserInfoUseCase
) : ViewModel(){
    fun getUserInfo() = liveData {
        val userInfoList = getUserInfoUseCase.execute()
        emit(userInfoList)
    }
}

class UserInfoViewModelFactory(
    private val getUserInfoUseCase: GetUserInfoUseCase
) : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserInfoViewModel(getUserInfoUseCase) as T
    }

}
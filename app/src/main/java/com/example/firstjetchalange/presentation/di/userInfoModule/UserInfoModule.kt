package com.example.firstjetchalange.presentation.di.userInfoModule

import com.example.firstjetchalange.domain.usecase.GetUserInfoUseCase
import com.example.firstjetchalange.presentation.view.viewModel.UserInfoViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class UserInfoModule {
    @UserInfoScope
    @Provides
    fun provideUserInfoViewModelFactory(
        getUserInfoUseCase: GetUserInfoUseCase
    ) : UserInfoViewModelFactory{
        return UserInfoViewModelFactory(
            getUserInfoUseCase
        )
    }
}
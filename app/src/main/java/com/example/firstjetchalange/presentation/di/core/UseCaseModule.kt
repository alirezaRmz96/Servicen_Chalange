package com.example.firstjetchalange.presentation.di.core

import com.example.firstjetchalange.domain.repository.AlbumIdRepository
import com.example.firstjetchalange.domain.repository.UserInfoRepository
import com.example.firstjetchalange.domain.usecase.GetAlbumIdUseCase
import com.example.firstjetchalange.domain.usecase.GetUserInfoUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {
    @Provides
    fun provideGetUseInfoUseCase(
        userInfoRepository: UserInfoRepository
    ):GetUserInfoUseCase{
        return GetUserInfoUseCase(userInfoRepository)
    }
    @Provides
    fun provideGetAlbumIdUseCase(
        albumIdRepository: AlbumIdRepository
    ):GetAlbumIdUseCase{
        return GetAlbumIdUseCase(albumIdRepository)
    }
}
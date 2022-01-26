package com.example.firstjetchalange.presentation.di.core

import com.example.firstjetchalange.data.api.ApiService
import com.example.firstjetchalange.data.repository.albumId.AlbumIdRemoteDataSource
import com.example.firstjetchalange.data.repository.albumId.AlbumIdRemoteDataSourceImpl
import com.example.firstjetchalange.data.repository.userInfo.UserInfoRemoteDataSource
import com.example.firstjetchalange.data.repository.userInfo.UserInfoRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule() {
    @Singleton
    @Provides
    fun provideUserInfoRemoteDataSource(
        apiService: ApiService
    ): UserInfoRemoteDataSource {
        return UserInfoRemoteDataSourceImpl(
            apiService
        )
    }
    @Singleton
    @Provides
    fun provideAlbumIdRemoteDataSource(
        apiService: ApiService
    ): AlbumIdRemoteDataSource{
        return AlbumIdRemoteDataSourceImpl(
            apiService
        )
    }

}
package com.example.firstjetchalange.presentation.di.core

import com.example.firstjetchalange.data.repository.albumId.AlbumIdRemoteDataSource
import com.example.firstjetchalange.data.repository.albumId.AlbumIdRepositoryImpl
import com.example.firstjetchalange.data.repository.userInfo.UserInfoRemoteDataSource
import com.example.firstjetchalange.data.repository.userInfo.UserInfoRepositoryImpl
import com.example.firstjetchalange.domain.repository.AlbumIdRepository
import com.example.firstjetchalange.domain.repository.UserInfoRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideUseInfoRepository(
        userInfoRemoteDataSource: UserInfoRemoteDataSource
    ):UserInfoRepository{
        return UserInfoRepositoryImpl(
            userInfoRemoteDataSource
        )
    }
    @Provides
    @Singleton
    fun provideAlbumIdRepository(
        albumIdRemoteDataSource: AlbumIdRemoteDataSource
    ):AlbumIdRepository{
        return AlbumIdRepositoryImpl(
            albumIdRemoteDataSource
        )
    }
}
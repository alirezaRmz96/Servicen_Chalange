package com.example.firstjetchalange.presentation.di.core

import com.example.firstjetchalange.data.repository.UserInfoRemoteDataSource
import com.example.firstjetchalange.data.repository.UserInfoRepositoryImpl
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
}
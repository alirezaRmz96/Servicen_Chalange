package com.example.firstjetchalange.presentation.di.core

import com.example.firstjetchalange.data.api.ApiService
import com.example.firstjetchalange.data.repository.UserInfoRemoteDataSource
import com.example.firstjetchalange.data.repository.UserInfoRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule() {
    @Singleton
    @Provides
    fun provideUserInfoRemoteDataSource(
        apiService: ApiService
    ): UserInfoRemoteDataSource{
        return UserInfoRemoteDataSourceImpl(
            apiService
        )
    }
}
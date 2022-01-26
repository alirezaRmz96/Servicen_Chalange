package com.example.firstjetchalange.data.repository.userInfo

import com.example.firstjetchalange.data.api.ApiService
import com.example.firstjetchalange.data.models.userInfo.UserInfoList
import com.example.firstjetchalange.data.repository.userInfo.UserInfoRemoteDataSource
import retrofit2.Response

class UserInfoRemoteDataSourceImpl(
    private val apiService: ApiService
) : UserInfoRemoteDataSource {
    override suspend fun getUserInfo():
            Response<UserInfoList> = apiService.getUserInfo()
}
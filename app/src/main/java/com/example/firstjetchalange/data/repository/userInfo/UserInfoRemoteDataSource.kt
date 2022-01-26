package com.example.firstjetchalange.data.repository.userInfo

import com.example.firstjetchalange.data.models.userInfo.UserInfoList
import retrofit2.Response

interface UserInfoRemoteDataSource {
    suspend fun getUserInfo():Response<UserInfoList>
}
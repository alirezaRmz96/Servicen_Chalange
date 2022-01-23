package com.example.firstjetchalange.data.api

import com.example.firstjetchalange.data.models.userInfo.UserInfoList
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    suspend fun getUserInfo(

    ):Response<UserInfoList>

}
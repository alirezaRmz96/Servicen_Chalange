package com.example.firstjetchalange.data.repository

import android.util.Log
import com.example.firstjetchalange.data.models.userInfo.UserInfoList
import com.example.firstjetchalange.domain.repository.UserInfoRepository
import java.lang.Exception

class UserInfoRepositoryImpl(
    private val userInfoRemoteDataSource: UserInfoRemoteDataSource
) :UserInfoRepository{
    override suspend fun getUserInfo(): List<UserInfoList>? {
        return getUserInfoFromApi()
    }

    suspend fun getUserInfoFromApi():List<UserInfoList>{
        lateinit var userInfoList : List<UserInfoList>
        try {
            val response = userInfoRemoteDataSource.getUserInfo()
            val body = response.body()
            if (body!=null){
                userInfoList = listOf(body)
            }
        }catch (exception: Exception){
            Log.i("MyTag", exception.message.toString())
        }
        return userInfoList
    }

}
package com.example.firstjetchalange.domain.repository

import com.example.firstjetchalange.data.models.userInfo.UserInfoList

interface UserInfoRepository {
    suspend fun getUserInfo():List<UserInfoList>?
}
package com.example.firstjetchalange.domain.usecase

import com.example.firstjetchalange.data.models.userInfo.UserInfoList
import com.example.firstjetchalange.domain.repository.UserInfoRepository

class GetUserInfoUseCase(private val userInfoRepository: UserInfoRepository) {
    suspend fun execute():List<UserInfoList>? = userInfoRepository.getUserInfo()
}
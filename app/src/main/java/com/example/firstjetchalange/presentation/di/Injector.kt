package com.example.firstjetchalange.presentation.di

import com.example.firstjetchalange.presentation.di.userModule.UserInfoSubComponent

interface Injector {
    fun createUseInfoSubComponent():UserInfoSubComponent
}
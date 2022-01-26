package com.example.firstjetchalange.presentation.di

import com.example.firstjetchalange.presentation.di.albumId.AlbumIdSubComponent
import com.example.firstjetchalange.presentation.di.userInfoModule.UserInfoSubComponent

interface Injector {
    fun createUseInfoSubComponent():UserInfoSubComponent
    fun createAlbumIdSubComponent():AlbumIdSubComponent

}
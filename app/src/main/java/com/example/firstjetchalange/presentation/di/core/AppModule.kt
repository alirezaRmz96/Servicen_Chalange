package com.example.firstjetchalange.presentation.di.core

import android.content.Context
import com.example.firstjetchalange.presentation.di.albumId.AlbumIdSubComponent
import com.example.firstjetchalange.presentation.di.userInfoModule.UserInfoSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [UserInfoSubComponent::class,AlbumIdSubComponent::class])
class AppModule (private val context:Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}
package com.example.firstjetchalange.presentation.di.core

import android.content.Context
import com.example.firstjetchalange.presentation.di.userModule.UserInfoSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [UserInfoSubComponent::class])
class AppModule (private val context:Context) {

    @Singleton
    @Provides
    fun provideApplicationContext():Context{
        return context.applicationContext
    }
}
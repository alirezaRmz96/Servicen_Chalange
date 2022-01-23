package com.example.firstjetchalange.presentation.di.core

import com.example.firstjetchalange.presentation.di.userModule.UserInfoSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
    NetModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class
])

interface AppComponent {
    fun userInfoSubComponent():UserInfoSubComponent.Factory
}
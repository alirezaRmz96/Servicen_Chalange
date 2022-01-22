package com.example.firstjetchalange.presentation.di.core

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AppModule::class,
])
interface AppComponent {
}
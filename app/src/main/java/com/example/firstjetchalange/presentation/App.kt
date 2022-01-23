package com.example.firstjetchalange.presentation

import android.app.Application
import com.example.firstjetchalange.BuildConfig
import com.example.firstjetchalange.presentation.di.Injector
import com.example.firstjetchalange.presentation.di.core.AppComponent
import com.example.firstjetchalange.presentation.di.core.AppModule
import com.example.firstjetchalange.presentation.di.core.DaggerAppComponent
import com.example.firstjetchalange.presentation.di.core.NetModule
import com.example.firstjetchalange.presentation.di.userModule.UserInfoSubComponent

class App:Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .build()
    }

    override fun createUseInfoSubComponent(): UserInfoSubComponent {
        return appComponent.userInfoSubComponent().create()
    }
}
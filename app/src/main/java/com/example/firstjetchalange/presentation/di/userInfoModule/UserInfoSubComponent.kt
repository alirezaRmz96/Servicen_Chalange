package com.example.firstjetchalange.presentation.di.userInfoModule

import com.example.firstjetchalange.presentation.view.fragments.UserInfoFragment
import dagger.Subcomponent

@UserInfoScope
@Subcomponent(modules = [UserInfoModule::class])
interface UserInfoSubComponent {

    fun inject(userInfoFragment: UserInfoFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():UserInfoSubComponent
    }
}
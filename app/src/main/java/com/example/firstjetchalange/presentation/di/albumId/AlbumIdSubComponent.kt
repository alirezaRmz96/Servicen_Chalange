package com.example.firstjetchalange.presentation.di.albumId

import com.example.firstjetchalange.presentation.view.fragments.AlbumIdFragment
import dagger.Subcomponent

@AlbumIdScope
@Subcomponent(modules = [AlbumIdModule::class])
interface AlbumIdSubComponent {

    fun inject(albumIdFragment: AlbumIdFragment)

    @Subcomponent.Factory
    interface Factory{
        fun create():AlbumIdSubComponent
    }
}
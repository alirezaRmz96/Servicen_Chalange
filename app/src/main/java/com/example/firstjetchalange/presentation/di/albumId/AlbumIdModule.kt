package com.example.firstjetchalange.presentation.di.albumId

import com.example.firstjetchalange.domain.usecase.GetAlbumIdUseCase
import com.example.firstjetchalange.presentation.view.viewModel.AlbumIdViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class AlbumIdModule {
    @AlbumIdScope
    @Provides
    fun provideAlbumIdViewModelFactory(
        getAlbumIdUseCase: GetAlbumIdUseCase
    ):AlbumIdViewModelFactory{
        return AlbumIdViewModelFactory(
            getAlbumIdUseCase
        )
    }
}
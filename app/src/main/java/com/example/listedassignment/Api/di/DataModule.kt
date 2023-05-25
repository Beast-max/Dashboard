package com.example.listedassignment.Api.di

import com.example.listedassignment.Api.EndPoint
import com.example.listedassignment.ViewModel.CentralRepository
import com.example.listedassignment.ViewModel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Singleton
    @Provides
    fun provideCentralRepository(endPoint: EndPoint):CentralRepository = CentralRepository(endPoint)

    @Provides
    @Singleton
    fun provideMainViewModel(repository: CentralRepository): MainViewModel {
        return MainViewModel(repository)
    }

}
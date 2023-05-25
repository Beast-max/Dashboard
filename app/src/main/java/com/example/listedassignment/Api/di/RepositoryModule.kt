package com.example.listedassignment.Api.di

import com.example.listedassignment.Api.EndPoint
import com.example.listedassignment.ViewModel.CentralRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {
    @Singleton
    @Provides
    fun provideCentralRepository(endPoint: EndPoint):CentralRepository = CentralRepository(endPoint)
}
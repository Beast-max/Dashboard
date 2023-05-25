package com.example.listedassignment.Api.di

import com.example.listedassignment.Api.EndPoint
import com.example.listedassignment.Api.ServiceInterceptor
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {
    @Singleton
    @Provides
    fun provideGsonBuilder(): Gson =
        GsonBuilder()
            .excludeFieldsWithoutExposeAnnotation()
            .create()



    var mHttpLoggingInterceptor = HttpLoggingInterceptor()
        .setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun okHttpClint(): OkHttpClient {
        return OkHttpClient
            .Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .addInterceptor(mHttpLoggingInterceptor)
            .addInterceptor(ServiceInterceptor())
            .build()
    }
    @Singleton
    @Provides
    fun provideRetrofit(gson:Gson,okHttpClient:OkHttpClient): Retrofit.Builder=
        Retrofit.Builder()
            .baseUrl("https://api.inopenapp.com/api/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))

    @Singleton
    @Provides
    fun provideService(retrofit:Retrofit.Builder): EndPoint {
        return retrofit.build().create(EndPoint::class.java)
    }
}
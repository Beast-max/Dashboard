package com.example.listedassignment.Api

import com.example.listedassignment.Api.model.GetDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface EndPoint {
    @GET("v1/{name}")
    suspend fun getData(@Path("name")name:String):Response<GetDataResponse>
}
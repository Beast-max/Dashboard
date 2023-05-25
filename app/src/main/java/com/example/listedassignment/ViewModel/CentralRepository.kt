package com.example.listedassignment.ViewModel

import com.example.listedassignment.Api.EndPoint
import com.example.listedassignment.Api.model.GetDataResponse
import retrofit2.Response
import javax.inject.Inject

class CentralRepository @Inject constructor(private val endPoint:EndPoint) {

    suspend fun getDashBoard(name:String):Response<GetDataResponse>{
        return endPoint.getData(name)
    }

}
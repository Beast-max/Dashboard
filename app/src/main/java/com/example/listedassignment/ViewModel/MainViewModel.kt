package com.example.listedassignment.ViewModel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.listedassignment.Api.BaseResponse
import com.example.listedassignment.Api.model.GetDataResponse
import com.example.listedassignment.Api.model.TopLink
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val centralRepository: CentralRepository) :ViewModel() {
     val dashboardLiveData = MutableLiveData<BaseResponse<GetDataResponse>>()

    fun getDashboardData(name:String) = viewModelScope.launch {
        dashboardLiveData.postValue(BaseResponse.Loading())
        val response = centralRepository.getDashBoard(name)
        Log.d("response",response.body().toString())
        try {
            if(response.code()==200){
                dashboardLiveData.postValue(BaseResponse.Success(response.body()))
            }
            else{
                dashboardLiveData.postValue(BaseResponse.Error(response.body()?.message))
            }
        }catch (e:Exception){
            dashboardLiveData.postValue(BaseResponse.Error(e.message))
        }
    }
}
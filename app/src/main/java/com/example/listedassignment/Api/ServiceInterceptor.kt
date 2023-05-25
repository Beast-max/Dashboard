package com.example.listedassignment.Api

import com.example.listedassignment.Utiles.BaseApplication
import com.example.listedassignment.Utiles.SessionManager
import okhttp3.Interceptor
import okhttp3.Response

class ServiceInterceptor:Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        val token = BaseApplication.getContext()?.let { SessionManager.getToken(it) }
        if (!token.isNullOrEmpty()) {
            val finalToken = "Bearer $token"
            request = request.newBuilder()
                .addHeader("Authorization", finalToken)
                .build()
        }
        return chain.proceed(request)
    }
}
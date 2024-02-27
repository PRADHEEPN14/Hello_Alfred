package com.helloalfred.network

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException


class ErrorInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val response: Response = chain.proceed(chain.request())
        if (!response.isSuccessful) {
            // Handle error codes here
            when (response.code) {
                400 -> {}
                401 -> {}
                403 -> {}
                405 -> {}
            }
        }
        return response
    }
}
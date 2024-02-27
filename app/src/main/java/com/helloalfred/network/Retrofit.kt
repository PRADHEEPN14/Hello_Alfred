package com.helloalfred.network

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory


object NetworkClient {
    private const val BASE_URL = "https://api.example.com/"
    fun createService(context: Context): ApiService {
        val okHttpClient: OkHttpClient = buildOkHttpClient(context)
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }

    private fun buildOkHttpClient(context: Context): OkHttpClient {
        val httpClientBuilder: OkHttpClient.Builder = OkHttpClient.Builder()

        // Logging interceptor for debugging purposes
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        httpClientBuilder.addInterceptor(loggingInterceptor)

        // Connectivity check interceptor
        httpClientBuilder.addInterceptor { chain ->
            if (!isConnected(context)) {
                throw NoConnectivityException()
            }
            chain.proceed(chain.request())
        }

        // Custom error code handling interceptor
        httpClientBuilder.addInterceptor(ErrorInterceptor())
        return httpClientBuilder.build()
    }

    private fun isConnected(context: Context): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = connectivityManager.activeNetworkInfo
        return activeNetwork != null && activeNetwork.isConnectedOrConnecting
        return false
    }
}
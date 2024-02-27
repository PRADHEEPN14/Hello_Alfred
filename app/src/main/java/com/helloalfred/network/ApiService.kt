package com.helloalfred.network

import com.helloalfred.model.User
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query


interface ApiService {
    @get:GET("users")
    val users: Call<List<User?>?>?

    // POST request to create a new user
    @POST("users")
    fun createUser(@Body newUser: User?): Call<User?>?

    // PUT request to update an existing user
    @PUT("users/{userId}")
    fun updateUser(@Path("userId") userId: String?, @Body updatedUser: User?): Call<User?>?

    // GET request with query parameter
    @GET("search/users")
    fun searchUsers(@Query("query") query: String?): Call<List<User?>?>?

    // POST request with custom headers
    @POST("users")
    fun createUserWithHeaders(
        @Header("Authorization") authToken: String?,
        @Body newUser: User?
    ): Call<User?>?

    // PUT request with custom headers
    @PUT("users/{userId}")
    fun updateUserWithHeaders(
        @Path("userId") userId: String?,
        @Header("Authorization") authToken: String?,
        @Body updatedUser: User?
    ): Call<User?>?
}

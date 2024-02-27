package com.helloalfred.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.helloalfred.model.User
import com.helloalfred.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserViewModel(private val apiService: ApiService) : ViewModel() {
    private val isLoading = MutableLiveData<Boolean>()

    val loadingState: LiveData<Boolean>
        get() = isLoading

    // function to create a new user
    fun createUser(newUser: User?): LiveData<User?> {
        val userLiveData = MutableLiveData<User?>()
        // Set loading to true before making the request
        isLoading.value = true

        apiService.createUser(newUser)!!.enqueue(object : Callback<User?> {
            override fun onResponse(call: Call<User?>, response: Response<User?>) {
                isLoading.value = false // Set loading to false after getting the response
                if (response.isSuccessful) {
                    userLiveData.setValue(response.body())
                } else {
                    // Handle non-successful response
                    // You might want to parse the error body or log the error
                    userLiveData.setValue(null)
                }
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {
                isLoading.value = false // Set loading to false in case of failure
                // Handle network errors here
                userLiveData.value = null
            }
        })
        return userLiveData
    }

    // function to update an existing user
    fun updateUser(userId: String?, updatedUser: User?): LiveData<User?> {
        val userLiveData = MutableLiveData<User?>()
        // Set loading to true before making the request
        isLoading.value = true
        apiService.updateUser(userId, updatedUser)!!.enqueue(object : Callback<User?> {
            override fun onResponse(call: Call<User?>, response: Response<User?>) {
                // Set loading to false after getting the response
                isLoading.value = false
                if (response.isSuccessful) {
                    userLiveData.setValue(response.body())
                } else {
                    // Handle non-successful response
                    // You might want to parse the error body or log the error
                    userLiveData.setValue(null)
                }
            }

            override fun onFailure(call: Call<User?>, t: Throwable) {
                isLoading.value = false // Set loading to false in case of failure
                // Handle network errors here
                userLiveData.value = null
            }
        })
        return userLiveData
    }
}


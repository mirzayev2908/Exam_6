package com.example.exam_6

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {

    companion object{

        private val TAG: String = ApiClient::class.java.simpleName
        const val IS_TESTER: Boolean = true
        private const val SERVER_DEVELOPMENT = "https://6221f0e7666291106a17fe77.mockapi.io/okay/"
        private const val SERVER_PRODUCTION = "https://6221f0e7666291106a17fe77.mockapi.io/okay/"

        private fun server(): String{
            return if(IS_TESTER){
                SERVER_DEVELOPMENT
            }else{
                SERVER_PRODUCTION
            }
        }

        private fun getRetrofit(): Retrofit {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(server())
                .build()
        }

        val apiService = getRetrofit().create(ApiService::class.java)
    }
}
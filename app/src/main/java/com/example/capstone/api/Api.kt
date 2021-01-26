package com.example.capstone.api

import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api {

    companion object {
        private val baseUrl = "https://apex.tracker.gg/apex/"

        class Interceptor : okhttp3.Interceptor {
            override fun intercept(chain: okhttp3.Interceptor.Chain): Response {
                val url = chain.request().url.newBuilder().build()
                val newRequest = chain.request().newBuilder().url(url).build()
                return chain.proceed(newRequest)
            }
        }

        fun createApi(): ApiService {
            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .addInterceptor(Interceptor())
                .build()

            val triviaApi = Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            return triviaApi.create(ApiService::class.java)
        }
    }
}
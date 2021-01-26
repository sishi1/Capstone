package com.example.capstone.api

import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("")
    suspend fun getPlayer(@Path("player") player: String)
}
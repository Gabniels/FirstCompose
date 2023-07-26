package com.example.allincompose.service

import com.example.allincompose.model.CoinResponse
import retrofit2.http.GET

interface CoinService {

    @GET("coins")
    suspend fun getCoins(): List<CoinResponse>
}
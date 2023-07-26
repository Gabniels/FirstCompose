package com.example.allincompose.repository.coin

import com.example.allincompose.model.CoinResponse
import com.example.allincompose.network.RetrofitInstance

class CoinRepository {

    private val coinService = RetrofitInstance.coinService

    suspend fun getCoins(): List<CoinResponse> {
        return coinService.getCoins()
    }

}
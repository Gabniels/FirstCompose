package com.example.allincompose.service

import com.example.allincompose.model.CreditCardResponse
import retrofit2.http.GET

interface CreditCardService {

    @GET("credit_cards")
    suspend fun getCreditCards(): CreditCardResponse

}
package com.example.allincompose.repository.creditcard

import com.example.allincompose.model.CreditCardResponse
import com.example.allincompose.network.RetrofitInstance

class CreditCardRepository {
    private val creditCardService = RetrofitInstance.creditCardService

    suspend fun getCreditCards(): CreditCardResponse {
        return creditCardService.getCreditCards()
    }

}
package com.example.allincompose.network

import com.example.allincompose.service.CreditCardService
import com.example.allincompose.service.PlaceholderService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private fun getClient(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val creditCardService: CreditCardService by lazy {
        getClient("https://random-data-api.com/api/v2/").create(CreditCardService::class.java)
    }

    val placeholderService: PlaceholderService by lazy {
        getClient("https://jsonplaceholder.typicode.com/").create(PlaceholderService::class.java)
    }

}
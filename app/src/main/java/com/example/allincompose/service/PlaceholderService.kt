package com.example.allincompose.service

import com.example.allincompose.model.PlaceholderResponse
import retrofit2.http.GET

interface PlaceholderService {

    @GET("posts")
    suspend fun getPlaceholder(): List<PlaceholderResponse>

}
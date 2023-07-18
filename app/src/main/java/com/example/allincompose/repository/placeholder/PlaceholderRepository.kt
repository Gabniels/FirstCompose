package com.example.allincompose.repository.placeholder

import com.example.allincompose.model.PlaceholderResponse
import com.example.allincompose.network.RetrofitInstance

class PlaceholderRepository {
    private val placeholderService = RetrofitInstance.placeholderService

    suspend fun getPlaceholder() : List<PlaceholderResponse> {
        return placeholderService.getPlaceholder()
    }

}
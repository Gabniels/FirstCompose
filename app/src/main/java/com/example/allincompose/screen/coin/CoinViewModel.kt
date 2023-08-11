package com.example.allincompose.screen.coin

import androidx.annotation.ColorInt
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.allincompose.model.CoinResponse
import com.example.allincompose.repository.coin.CoinRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CoinViewModel : ViewModel() {
    private val repository = CoinRepository()

    private val _coins = MutableStateFlow<List<CoinResponse>>(emptyList())
    val coins: StateFlow<List<CoinResponse>> = _coins.asStateFlow()

    fun getCoins() {
        viewModelScope.launch {
            try {
                val coin = repository.getCoins()
                _coins.value = coin
            } catch (e: Exception) {
                print(e)
            }
        }
    }
}
package com.example.allincompose.screen.coin

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.allincompose.model.CoinResponse
import com.example.allincompose.repository.coin.CoinRepository
import kotlinx.coroutines.launch

class CoinViewModel : ViewModel() {
    private val repository = CoinRepository()

    private val _coins = MutableLiveData<List<CoinResponse>>()
    val coins: LiveData<List<CoinResponse>> = _coins

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
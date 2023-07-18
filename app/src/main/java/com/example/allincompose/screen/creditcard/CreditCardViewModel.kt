package com.example.allincompose.screen.creditcard

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allincompose.model.CreditCardResponse
import com.example.allincompose.model.PlaceholderResponse
import com.example.allincompose.repository.creditcard.CreditCardRepository
import com.example.allincompose.repository.placeholder.PlaceholderRepository
import kotlinx.coroutines.launch

class CreditCardViewModel : ViewModel() {
    private val repository = CreditCardRepository()

    private val _creditCards = MutableLiveData<CreditCardResponse>()
    val creditCards: LiveData<CreditCardResponse> = _creditCards

    fun getCreditCards() {
        viewModelScope.launch {
            try {
                val cards = repository.getCreditCards()
                _creditCards.value = cards
            } catch (e: Exception) {
                print(e)
            }
        }
    }


}
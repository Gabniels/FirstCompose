package com.example.allincompose.screen.placeholder

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.allincompose.model.PlaceholderResponse
import com.example.allincompose.repository.placeholder.PlaceholderRepository
import kotlinx.coroutines.launch

class PlaceholderViewModel : ViewModel() {

    private val repository = PlaceholderRepository()

    private val _placeholder = MutableLiveData<List<PlaceholderResponse>>()
    val placeholder: LiveData<List<PlaceholderResponse>> = _placeholder

    fun getPlaceholder() {
        viewModelScope.launch {
            try {
                val data = repository.getPlaceholder()
                _placeholder.value = data
            } catch (e: Exception) {
                print(e)
            }
        }
    }

}
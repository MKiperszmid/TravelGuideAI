package com.mkiperszmid.travelguideai.home.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mkiperszmid.travelguideai.home.domain.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    init {
        viewModelScope.launch {
            repository.getTravelGuide().onSuccess {
                println(it)
            }.onFailure {
                println("Hubo un error")
            }
        }
    }
}

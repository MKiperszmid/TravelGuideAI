package com.mkiperszmid.travelguideai.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.mkiperszmid.travelguideai.home.domain.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {

    var state by mutableStateOf(HomeState())
        private set

    init {
        /*viewModelScope.launch {
            repository.getTravelGuide().onSuccess {
                println(it)
            }.onFailure {
                println("Hubo un error")
            }
        }*/
    }

    fun onSearchTextChange(newText: String) {
        state = state.copy(
            searchText = newText
        )
    }
}

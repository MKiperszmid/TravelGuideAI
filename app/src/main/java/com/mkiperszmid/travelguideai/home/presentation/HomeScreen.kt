package com.mkiperszmid.travelguideai.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.mkiperszmid.travelguideai.home.presentation.components.HomeSearchBar

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "A donde viajas?")
        HomeSearchBar(
            onSearch = {},
            placeholder = "Pais, Ciudad",
            inputText = state.searchText,
            onValueChange = { viewModel.onSearchTextChange(it) },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

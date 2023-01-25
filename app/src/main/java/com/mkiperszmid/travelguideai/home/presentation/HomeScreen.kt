package com.mkiperszmid.travelguideai.home.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.mkiperszmid.travelguideai.home.presentation.components.HomeFilterButton
import com.mkiperszmid.travelguideai.home.presentation.components.HomeFilterDialog
import com.mkiperszmid.travelguideai.home.presentation.components.HomePopularFilter
import com.mkiperszmid.travelguideai.home.presentation.components.HomeSearchBar

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel()
) {
    val state = viewModel.state

    if (state.showDialog) {
        HomeFilterDialog(onDismiss = {
            viewModel.onFilterDismiss()
        }, filterSettings = state.filterSettings, onAction = {
                viewModel.onSettingsChange(it)
            })
    }

    BackHandler(state.chatReply != null) {
        viewModel.onBackPress()
    }

    LazyColumn(modifier = Modifier.fillMaxSize()) {
        item {
            Text(text = "A donde viajas?")
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth().padding(16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HomeSearchBar(
                    onSearch = {
                        viewModel.search()
                    },
                    placeholder = "Pais, Ciudad",
                    inputText = state.searchText,
                    onValueChange = { viewModel.onSearchTextChange(it) }
                )
                HomeFilterButton(onClick = { viewModel.onFilterClick() })
            }
        }

        state.chatReply?.let {
            item {
                Text(text = it)
            }
        } ?: item {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(text = "Lugares Populares")
                HomePopularFilter(
                    modifier = Modifier.fillMaxWidth(),
                    selectedRegion = state.selectedRegion,
                    selectRegion = {
                        viewModel.onRegionSelect(it)
                    }
                )
                LazyRow(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    items(state.popularPlaces) {
                        TextButton(onClick = {
                            viewModel.onSearchTextChange("${it.country}, ${it.city}")
                        }) {
                            Text(text = "${it.country}, ${it.city}")
                        }
                    }
                }
            }
        }
    }
}

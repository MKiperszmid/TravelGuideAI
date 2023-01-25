package com.mkiperszmid.travelguideai.home.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
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

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        contentPadding = PaddingValues(top = 32.dp)
    ) {
        item {
            Text(
                text = "A donde viajas?",
                fontSize = 28.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
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

        if (state.isLoading) {
            item {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        } else {
            state.chatReply?.let {
                item {
                    Text(text = it, modifier = Modifier.padding(horizontal = 16.dp))
                }
            } ?: item {
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Lugares Populares",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    HomePopularFilter(
                        modifier = Modifier.fillMaxWidth().padding(horizontal = 16.dp),
                        selectedRegion = state.selectedRegion,
                        selectRegion = {
                            viewModel.onRegionSelect(it)
                        }
                    )
                    Spacer(modifier = Modifier.height(12.dp))
                    LazyRow(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(24.dp),
                        contentPadding = PaddingValues(horizontal = 16.dp)
                    ) {
                        items(state.popularPlaces) {
                            Box(
                                modifier = Modifier.size(180.dp, 250.dp)
                                    .clip(RoundedCornerShape(20.dp))
                                    .clickable {
                                        viewModel.onSearchTextChange("${it.country}, ${it.city}")
                                    }
                            ) {
                                AsyncImage(
                                    model = it.image,
                                    contentDescription = "${it.country} ${it.city}",
                                    contentScale = ContentScale.Crop
                                )
                                Text(
                                    text = "${it.country}, ${it.city}",
                                    color = Color.White,
                                    fontSize = 13.sp,
                                    fontWeight = FontWeight.Black,
                                    modifier = Modifier.align(Alignment.BottomStart).padding(12.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

package com.mkiperszmid.travelguideai.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import com.mkiperszmid.travelguideai.home.domain.model.Region
import com.mkiperszmid.travelguideai.ui.theme.DarkGreen

@Composable
fun HomePopularFilter(
    selectedRegion: Region,
    selectRegion: (Region) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Region.values().forEach {
            val textColor = if (it == selectedRegion) DarkGreen else Color.Gray
            TextButton(
                onClick = { selectRegion(it) }
            ) {
                Text(text = it.name.lowercase().capitalize(Locale.current), color = textColor)
            }
        }
    }
}

@Preview
@Composable
fun HomePopularFilterPreview() {
    HomePopularFilter(
        selectedRegion = Region.OCEANIA,
        {}
    )
}

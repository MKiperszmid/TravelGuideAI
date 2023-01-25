package com.mkiperszmid.travelguideai.home.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.mkiperszmid.travelguideai.home.domain.model.Place
import com.mkiperszmid.travelguideai.home.domain.model.Region

@Composable
fun HomePopularPlaceItem(
    place: Place,
    onPlaceClick: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.size(180.dp, 250.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable {
                onPlaceClick("${place.country}, ${place.city}")
            }
    ) {
        AsyncImage(
            model = place.image,
            contentDescription = "${place.country} ${place.city}",
            contentScale = ContentScale.Crop
        )
        Text(
            text = "${place.country}, ${place.city}",
            color = Color.White,
            fontSize = 13.sp,
            fontWeight = FontWeight.Black,
            modifier = Modifier.align(Alignment.BottomStart).padding(12.dp),
            style = TextStyle(
                shadow = Shadow(
                    color = Color.Black,
                    offset = Offset(3f, 3f),
                    blurRadius = 5f
                )
            )
        )
    }
}

@Preview
@Composable
fun HomePopularPlaceItemPreview() {
    HomePopularPlaceItem(
        place = Place("Argentina", "Buenos Aires", Region.AMERICA, ""),
        onPlaceClick = {}
    )
}

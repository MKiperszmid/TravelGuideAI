package com.mkiperszmid.travelguideai.home.presentation.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mkiperszmid.travelguideai.home.presentation.HomeFilterDialogAction
import com.mkiperszmid.travelguideai.home.domain.model.HomeFilterSettings

@Composable
fun HomeFilterDialog(
    onDismiss: () -> Unit,
    filterSettings: HomeFilterSettings,
    onAction: (HomeFilterDialogAction) -> Unit,
    modifier: Modifier = Modifier
) {
    AlertDialog(onDismissRequest = onDismiss, modifier = modifier.fillMaxWidth(), buttons = {
        Button(
            onClick = { onAction(HomeFilterDialogAction.OnApplyClick) },
            modifier = Modifier.fillMaxWidth().padding(16.dp)
        ) {
            Text(text = "Aplicar")
        }
    }, text = {
            Column(modifier = Modifier.fillMaxWidth()) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Personas")
                    HomeFilterIncrement(
                        number = filterSettings.people,
                        onMinus = { onAction(HomeFilterDialogAction.OnPeopleMinus) },
                        onPlus = { onAction(HomeFilterDialogAction.OnPeoplePlus) }
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Divider(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Restaurantes")
                    HomeFilterCheckbox(
                        onClick = { onAction(HomeFilterDialogAction.OnRestaurantClick) },
                        isChecked = filterSettings.restaurant
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                Divider(modifier = Modifier.fillMaxWidth())
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "Museos")
                    HomeFilterCheckbox(
                        onClick = { onAction(HomeFilterDialogAction.OnMuseumClick) },
                        isChecked = filterSettings.museums
                    )
                }
            }
        }, shape = RoundedCornerShape(30.dp))
}

@Preview
@Composable
fun HomeFilterDialogPreview() {
    HomeFilterDialog({}, filterSettings = HomeFilterSettings(), {})
}

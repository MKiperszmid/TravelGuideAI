package com.mkiperszmid.travelguideai.home.presentation

sealed interface HomeFilterDialogAction {
    object OnApplyClick : HomeFilterDialogAction
    object OnRestaurantClick : HomeFilterDialogAction
    object OnMuseumClick : HomeFilterDialogAction
    object OnPeoplePlus : HomeFilterDialogAction
    object OnPeopleMinus : HomeFilterDialogAction
}

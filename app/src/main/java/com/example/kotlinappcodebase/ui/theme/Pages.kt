package com.example.kotlinappcodebase.ui.theme

sealed class Pages(val route: String) {
    object CoinList: Pages("coin_list_page")
    object CoinDetails: Pages("coin_details_page")
}
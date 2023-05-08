package com.example.kotlinappcodebase.view

sealed class Pages(val route: String) {
    object CoinList: Pages("coin_list_page")
    object CoinDetails: Pages("coin_details_page")
}
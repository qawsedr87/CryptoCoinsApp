package com.example.kotlinappcodebase.ui.theme.coin_details

import com.example.kotlinappcodebase.data.model.CoinDetails

data class CoinDetailsState (
    val isLoading: Boolean = false,
    val coin: CoinDetails? = null,
    val error: String = ""
)
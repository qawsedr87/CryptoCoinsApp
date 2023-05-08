package com.example.kotlinappcodebase.view.coin_list

import com.example.kotlinappcodebase.data.model.Coin

data class CoinListState (
    val isLoading: Boolean = false,
    val coins: List<Coin> = emptyList(),
    val error: String = ""
)
package com.example.kotlinappcodebase.data.repository

import com.example.kotlinappcodebase.data.dto.CoinDetailsDto
import com.example.kotlinappcodebase.data.dto.CoinDto

interface CoinRepository {
    suspend fun getCoins(): List<CoinDto>
    suspend fun getCoinById(coinId: String): CoinDetailsDto
}
package com.example.kotlinappcodebase.repository

import com.example.kotlinappcodebase.data.CoinApi
import com.example.kotlinappcodebase.data.dto.CoinDetailsDto
import com.example.kotlinappcodebase.data.dto.CoinDto
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor(
    private val api: CoinApi
): CoinRepository {
    override suspend fun getCoins(): List<CoinDto> {
        return api.getCoins()
    }

    override suspend fun getCoinById(coinId: String): CoinDetailsDto {
        return api.getCoinById(coinId)
    }
}
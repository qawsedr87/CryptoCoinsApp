package com.example.kotlinappcodebase.data

import com.example.kotlinappcodebase.data.dto.toCoinDetails
import com.example.kotlinappcodebase.data.model.CoinDetails
import com.example.kotlinappcodebase.data.repository.CoinRepository
import com.example.kotlinappcodebase.utils.Resource
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinByIdData @Inject constructor(
  private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading<CoinDetails>())

            val coin = repository.getCoinById(coinId).toCoinDetails()
            emit(Resource.Success<CoinDetails>(coin))

        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetails>(e.localizedMessage ?: "An unexpected error occurred!"))

        } catch (e: IOException) {
            emit(Resource.Error<CoinDetails>("Couldn't reach server. Check your internet connection!"))
        }
    }
}
package com.example.kotlinappcodebase.service

import com.example.kotlinappcodebase.data.dto.toCoinDetails
import com.example.kotlinappcodebase.data.model.CoinDetails
import com.example.kotlinappcodebase.repository.CoinRepository
import com.example.kotlinappcodebase.utils.Constants
import com.example.kotlinappcodebase.utils.Resource
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.Flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinByIdService @Inject constructor(
  private val repository: CoinRepository
) {
    operator fun invoke(coinId: String): Flow<Resource<CoinDetails>> = flow {
        try {
            emit(Resource.Loading<CoinDetails>())

            val coin = repository.getCoinById(coinId).toCoinDetails()
            emit(Resource.Success<CoinDetails>(coin))

        } catch (e: HttpException) {
            emit(Resource.Error<CoinDetails>(e.localizedMessage ?: Constants.HTTP_ERROR_MESSAGE))

        } catch (e: IOException) {
            emit(Resource.Error<CoinDetails>(Constants.IO_ERROR_MESSAGE))
        }
    }
}
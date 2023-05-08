package com.example.kotlinappcodebase.service

import com.example.kotlinappcodebase.data.dto.toCoin
import com.example.kotlinappcodebase.data.model.Coin
import com.example.kotlinappcodebase.repository.CoinRepository
import com.example.kotlinappcodebase.utils.Constants
import com.example.kotlinappcodebase.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsService @Inject constructor(
  private val repository: CoinRepository
) {
    /** Flow is a Kotlin coroutine-based API that is used for asynchronous and non-blocking stream processing */
    /** flow: produces a stream of values asynchronously */
    operator fun invoke(): Flow<Resource<List<Coin>>> = flow {
        try {
            /** emit: represents the state of the asynchronous operation. */
            emit(Resource.Loading<List<Coin>>())

            val coins = repository.getCoins().map { it.toCoin() }
            emit(Resource.Success<List<Coin>>(coins))

        } catch (e: HttpException) {
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: Constants.HTTP_ERROR_MESSAGE))

        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>(Constants.IO_ERROR_MESSAGE))
        }
    }
}
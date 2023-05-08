package com.example.kotlinappcodebase.data

import com.example.kotlinappcodebase.data.dto.toCoin
import com.example.kotlinappcodebase.data.model.Coin
import com.example.kotlinappcodebase.data.repository.CoinRepository
import com.example.kotlinappcodebase.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsData @Inject constructor(
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
            emit(Resource.Error<List<Coin>>(e.localizedMessage ?: "An unexpected error occurred!"))

        } catch (e: IOException) {
            emit(Resource.Error<List<Coin>>("Couldn't reach server. Check your internet connection!"))
        }
    }
}
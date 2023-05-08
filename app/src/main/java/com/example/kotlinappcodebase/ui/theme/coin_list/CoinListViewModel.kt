package com.example.kotlinappcodebase.ui.theme.coin_list

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.kotlinappcodebase.service.GetCoinsService
import com.example.kotlinappcodebase.utils.Constants
import com.example.kotlinappcodebase.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(
    private val getCoinsService: GetCoinsService
): ViewModel() {

    private val _state = mutableStateOf(CoinListState())

    val state: State<CoinListState> = _state

    init {
        getCoins()
    }

    private fun getCoins() {
        getCoinsService().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = CoinListState(coins = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = CoinListState(
                        error = result.message ?: Constants.HTTP_ERROR_MESSAGE
                    )
                }
                is Resource.Loading -> {
                    _state.value = CoinListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
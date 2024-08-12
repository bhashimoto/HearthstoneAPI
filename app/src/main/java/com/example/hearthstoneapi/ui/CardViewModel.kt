package com.example.hearthstoneapi.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hearthstoneapi.network.CardDetail
import com.example.hearthstoneapi.network.HearthstoneApi
import kotlinx.coroutines.launch
import okio.IOException
import retrofit2.HttpException

sealed interface CardUiState {
    data class Success(val card: CardDetail) : CardUiState
    data object Error : CardUiState
    data object Loading : CardUiState
}

class CardViewModel(private val cardId: String) : ViewModel() {
    var cardUiState: CardUiState by mutableStateOf(CardUiState.Loading)

    init {
        getCardDetails(cardId)
        Log.i("CardViewModel", "instantiating CardViewModel")
    }

    fun getCardDetails(cardId: String) {
        viewModelScope.launch {
            cardUiState = CardUiState.Loading
            cardUiState = try {
                CardUiState.Success(HearthstoneApi.retrofitService.getCard(cardId)[0])
            } catch (e: IOException) {
                CardUiState.Error
            } catch (e: HttpException) {
                CardUiState.Error
            }

        }
    }
}
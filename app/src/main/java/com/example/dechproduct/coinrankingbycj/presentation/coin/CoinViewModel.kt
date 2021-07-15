package com.example.dechproduct.coinrankingbycj.presentation.coin

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.dechproduct.coinrankingbycj.domain.usecase.GetCoinsUseCase
import com.example.dechproduct.coinrankingbycj.domain.usecase.UpdateCoinsUseCase

class CoinViewModel(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val updateCoinsUseCase: UpdateCoinsUseCase
) : ViewModel() {

    fun getCoins() = liveData {
        val coinList = getCoinsUseCase.execute()
        emit(coinList)
    }

    fun updateCoins() = liveData {
        val coinList = updateCoinsUseCase.execute()
        emit(coinList)
    }


}
package com.example.dechproduct.coinrankingbycj.presentation.coin

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dechproduct.coinrankingbycj.domain.usecase.GetCoinsUseCase
import com.example.dechproduct.coinrankingbycj.domain.usecase.UpdateCoinsUseCase

class CoinViewModelFactory(
    private val getCoinsUseCase: GetCoinsUseCase,
    private val updateCoinsUseCase: UpdateCoinsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CoinViewModel(getCoinsUseCase, updateCoinsUseCase) as T
    }
}
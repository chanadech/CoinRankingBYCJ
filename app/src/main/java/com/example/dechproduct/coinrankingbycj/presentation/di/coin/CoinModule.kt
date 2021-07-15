package com.example.dechproduct.coinrankingbycj.presentation.di.coin

import com.example.dechproduct.coinrankingbycj.domain.usecase.GetCoinsUseCase
import com.example.dechproduct.coinrankingbycj.domain.usecase.UpdateCoinsUseCase
import com.example.dechproduct.coinrankingbycj.presentation.coin.CoinViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class CoinModule {
    @CoinScope
    @Provides
    fun provideCoinViewModelFactory(
        getCoinsUseCase: GetCoinsUseCase,
        updateCoinsUseCase: UpdateCoinsUseCase
    ) : CoinViewModelFactory {
        return CoinViewModelFactory(
            getCoinsUseCase,
            updateCoinsUseCase
        )
    }
}
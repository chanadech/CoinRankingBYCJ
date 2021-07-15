package com.example.dechproduct.coinrankingbycj.presentation.di.core

import androidx.room.Update
import com.example.dechproduct.coinrankingbycj.domain.repository.CoinRepository
import com.example.dechproduct.coinrankingbycj.domain.usecase.GetCoinsUseCase
import com.example.dechproduct.coinrankingbycj.domain.usecase.UpdateCoinsUseCase
import dagger.Module
import dagger.Provides

@Module
class UseCaseModule {

    @Provides
    fun provideGetCoinUseCase(coinRepository: CoinRepository): GetCoinsUseCase {
        return GetCoinsUseCase(coinRepository)
    }

    @Provides
    fun provideUpdateCoinUseCase(coinRepository: CoinRepository):UpdateCoinsUseCase {
        return UpdateCoinsUseCase(coinRepository)
    }



}
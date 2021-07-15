package com.example.dechproduct.coinrankingbycj.presentation.di.core

import com.example.dechproduct.coinrankingbycj.data.api.CoinService
import com.example.dechproduct.coinrankingbycj.data.repository.datasource.CoinRemoteDataSource
import com.example.dechproduct.coinrankingbycj.data.repository.datasourceImpl.CoinRemoteDataSourceImpl
import com.example.dechproduct.coinrankingbycj.domain.repository.CoinRepository
import dagger.MapKey
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteDataModule(private val apiKey: String) {

    @Singleton
    @Provides
    fun provideCoinRemoteDataSource(coinService: CoinService): CoinRemoteDataSource {
        return CoinRemoteDataSourceImpl(
            coinService, apiKey
        )
    }


}
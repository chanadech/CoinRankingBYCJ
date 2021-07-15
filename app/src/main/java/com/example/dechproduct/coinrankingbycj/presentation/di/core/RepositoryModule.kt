package com.example.dechproduct.coinrankingbycj.presentation.di.core

import com.example.dechproduct.coinrankingbycj.data.repository.CoinRepositoryImpl
import com.example.dechproduct.coinrankingbycj.data.repository.datasource.CoinCacheDataSource
import com.example.dechproduct.coinrankingbycj.data.repository.datasource.CoinLocalDataSource
import com.example.dechproduct.coinrankingbycj.data.repository.datasource.CoinRemoteDataSource
import com.example.dechproduct.coinrankingbycj.domain.repository.CoinRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideCoinRepository (
        coinRemoteDataSource: CoinRemoteDataSource,
        coinLocalDataSource: CoinLocalDataSource,
        coinCacheDataSource: CoinCacheDataSource
    ): CoinRepository {

        return CoinRepositoryImpl (
            coinRemoteDataSource,
            coinLocalDataSource,
            coinCacheDataSource
                )
    }
}
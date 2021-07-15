package com.example.dechproduct.coinrankingbycj.presentation.di.core

import com.example.dechproduct.coinrankingbycj.data.db.CoinDao
import com.example.dechproduct.coinrankingbycj.data.repository.datasource.CoinLocalDataSource
import com.example.dechproduct.coinrankingbycj.data.repository.datasourceImpl.CoinLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideCoinLocalDataSource(coinDao: CoinDao): CoinLocalDataSource {
        return CoinLocalDataSourceImpl(coinDao)
    }

}
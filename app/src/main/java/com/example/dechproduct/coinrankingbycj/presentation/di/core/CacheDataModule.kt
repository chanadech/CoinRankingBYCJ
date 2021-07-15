package com.example.dechproduct.coinrankingbycj.presentation.di.core

import com.example.dechproduct.coinrankingbycj.data.repository.datasource.CoinCacheDataSource
import com.example.dechproduct.coinrankingbycj.data.repository.datasourceImpl.CoinCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideCoinCacheDataSource(): CoinCacheDataSource {
        return CoinCacheDataSourceImpl()
    }
    



}
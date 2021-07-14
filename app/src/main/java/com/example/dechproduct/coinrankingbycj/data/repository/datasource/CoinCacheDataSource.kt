package com.example.dechproduct.coinrankingbycj.data.repository.datasource

import com.example.dechproduct.coinrankingbycj.data.model.Coin

interface CoinCacheDataSource {
    suspend fun getCoinsFromCache(): List<Coin>
    suspend fun saveCoinsToCache(coins:List<Coin>)
}
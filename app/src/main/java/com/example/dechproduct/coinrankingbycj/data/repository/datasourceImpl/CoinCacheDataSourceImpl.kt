package com.example.dechproduct.coinrankingbycj.data.repository.datasourceImpl

import com.example.dechproduct.coinrankingbycj.data.model.Coin
import com.example.dechproduct.coinrankingbycj.data.repository.datasource.CoinCacheDataSource

class CoinCacheDataSourceImpl : CoinCacheDataSource {
    private var coinList = ArrayList <Coin>()

    override suspend fun getCoinsFromCache(): List<Coin> {
        return coinList
    }

    override suspend fun saveCoinsToCache(coins: List<Coin>) {
        coinList.clear()
        coinList = ArrayList(coins)
    }
}
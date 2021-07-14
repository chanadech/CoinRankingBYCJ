package com.example.dechproduct.coinrankingbycj.data.repository.datasource

import com.example.dechproduct.coinrankingbycj.data.model.Coin

interface CoinLocalDataSource {
    suspend fun getCoinsFromDB(): List<Coin>
    suspend fun saveCoinsToDB(coins:List<Coin>)
    suspend fun clearAll()
}
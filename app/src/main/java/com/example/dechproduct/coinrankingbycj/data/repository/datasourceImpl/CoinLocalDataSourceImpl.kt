package com.example.dechproduct.coinrankingbycj.data.repository.datasourceImpl

import com.example.dechproduct.coinrankingbycj.data.db.CoinDao
import com.example.dechproduct.coinrankingbycj.data.model.Coin
import com.example.dechproduct.coinrankingbycj.data.repository.datasource.CoinLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CoinLocalDataSourceImpl (private val coinDao: CoinDao): CoinLocalDataSource {
    override suspend fun getCoinsFromDB(): List<Coin> {
        return coinDao.getCoins()
    }

    override suspend fun saveCoinsToDB(coins: List<Coin>) {
        CoroutineScope(Dispatchers.IO).launch {
            coinDao.saveCoins(coins)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            coinDao.deleteAllCoins()
        }
    }
}
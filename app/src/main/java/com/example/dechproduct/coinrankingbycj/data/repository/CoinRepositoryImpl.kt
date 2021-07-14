package com.example.dechproduct.coinrankingbycj.data.repository

import android.util.Log
import com.example.dechproduct.coinrankingbycj.data.model.Coin
import com.example.dechproduct.coinrankingbycj.data.repository.datasource.CoinCacheDataSource
import com.example.dechproduct.coinrankingbycj.data.repository.datasource.CoinLocalDataSource
import com.example.dechproduct.coinrankingbycj.data.repository.datasource.CoinRemoteDataSource
import com.example.dechproduct.coinrankingbycj.domain.repository.CoinRepository
import java.lang.Exception

class CoinRepositoryImpl (
    private val coinRemoteDataSource: CoinRemoteDataSource,
    private val coinLocalDataSource: CoinLocalDataSource,
    private val coinCacheDataSource: CoinCacheDataSource
        ): CoinRepository {

    override suspend fun getCoins(): List<Coin>? {
       return getCoinsFromCache()
    }

    override suspend fun updateCoins(): List<Coin>? {
       val newListOfCoins = getCoinsFromAPI()
        coinLocalDataSource.clearAll()
        coinLocalDataSource.saveCoinsToDB(newListOfCoins)
        coinCacheDataSource.saveCoinsToCache(newListOfCoins)
        return newListOfCoins
    }


    suspend fun getCoinsFromAPI(): List<Coin> {
        lateinit var coinList: List<Coin>
        try {
            val response = coinRemoteDataSource.getCoins()
            val body = response.body()
            if(body!=null){
                coinList = body.coinList.coins
            }
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        return coinList
    }

    suspend fun getCoinsFromDB():List<Coin>{
        lateinit var coinList: List<Coin>
        try {
            coinList = coinLocalDataSource.getCoinsFromDB()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(coinList.size>0){
            return coinList
        }else{
            coinList=getCoinsFromAPI()
            coinLocalDataSource.saveCoinsToDB(coinList)
        }

        return coinList
    }

    suspend fun getCoinsFromCache():List<Coin>{
        lateinit var coinList: List<Coin>
        try {
            coinList =coinCacheDataSource.getCoinsFromCache()
        } catch (exception: Exception) {
            Log.i("MyTag", exception.message.toString())
        }
        if(coinList.size>0){
            return coinList
        }else{
            coinList=getCoinsFromDB()
            coinCacheDataSource.saveCoinsToCache(coinList)
        }

        return coinList
    }

}
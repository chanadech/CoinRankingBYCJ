package com.example.dechproduct.coinrankingbycj.data.repository.datasourceImpl

import androidx.room.PrimaryKey
import com.example.dechproduct.coinrankingbycj.data.api.CoinService
import com.example.dechproduct.coinrankingbycj.data.model.CoinBase
import com.example.dechproduct.coinrankingbycj.data.repository.datasource.CoinRemoteDataSource
import retrofit2.Response

class CoinRemoteDataSourceImpl (
    private val coinService: CoinService,
    private val apiKey: String
    ): CoinRemoteDataSource{
    override suspend fun getCoins(): Response<CoinBase> = coinService.getCoins(apiKey)

}
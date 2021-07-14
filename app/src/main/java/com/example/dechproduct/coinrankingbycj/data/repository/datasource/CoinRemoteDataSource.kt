package com.example.dechproduct.coinrankingbycj.data.repository.datasource

import com.example.dechproduct.coinrankingbycj.data.model.CoinBase
import retrofit2.Response

interface CoinRemoteDataSource {
    suspend fun getCoins(): Response<CoinBase>
}
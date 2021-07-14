package com.example.dechproduct.coinrankingbycj.data.api

import com.example.dechproduct.coinrankingbycj.data.model.CoinBase
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface CoinService {

    @GET("./Coins")
    suspend fun getCoins(
        @Query(
            "api_key"
        ) apiKey: String

    ): Response<CoinBase>
}
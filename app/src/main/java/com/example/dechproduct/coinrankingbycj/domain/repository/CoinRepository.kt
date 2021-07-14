package com.example.dechproduct.coinrankingbycj.domain.repository

import com.example.dechproduct.coinrankingbycj.data.model.Coin

interface CoinRepository {
    suspend fun getCoins(): List<Coin>?
    suspend fun updateCoins(): List<Coin>?
}
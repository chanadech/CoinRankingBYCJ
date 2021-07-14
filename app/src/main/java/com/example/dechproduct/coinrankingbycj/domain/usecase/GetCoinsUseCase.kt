package com.example.dechproduct.coinrankingbycj.domain.usecase

import com.example.dechproduct.coinrankingbycj.data.model.Coin
import com.example.dechproduct.coinrankingbycj.domain.repository.CoinRepository

class GetCoinsUseCase (private val coinRepository: CoinRepository){
    suspend fun execute():List<Coin>? = coinRepository.getCoins()
}
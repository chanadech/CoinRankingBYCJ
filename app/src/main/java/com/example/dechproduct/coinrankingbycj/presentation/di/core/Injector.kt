package com.example.dechproduct.coinrankingbycj.presentation.di.core

import com.example.dechproduct.coinrankingbycj.presentation.di.coin.CoinSubComponent

interface Injector {
    fun createCoinSubComponent(): CoinSubComponent
}
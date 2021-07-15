package com.example.dechproduct.coinrankingbycj.presentation.di.coin

import com.example.dechproduct.coinrankingbycj.presentation.coin.CoinActivity
import dagger.Subcomponent

@CoinScope
@Subcomponent(modules = [CoinModule::class])
interface CoinSubComponent {
    fun inject(coinActivity: CoinActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create(): CoinSubComponent
    }
}
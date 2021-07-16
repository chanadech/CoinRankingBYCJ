package com.example.dechproduct.coinrankingbycj.presentation

import android.app.Application
import com.example.dechproduct.coinrankingbycj.BuildConfig
import com.example.dechproduct.coinrankingbycj.presentation.di.coin.CoinSubComponent
import com.example.dechproduct.coinrankingbycj.presentation.di.core.*

class App : Application(), Injector{
    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createCoinSubComponent(): CoinSubComponent {
        return  appComponent.coinSubComponent().create()
    }
}
package com.example.dechproduct.coinrankingbycj.presentation.di.core

import android.content.Context
import com.example.dechproduct.coinrankingbycj.presentation.di.coin.CoinSubComponent
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [CoinSubComponent::class])
class AppModule(private val context: Context) {

    @Singleton
    @Provides
    fun provideApplicationContext(): Context {
        return context.applicationContext
    }
}
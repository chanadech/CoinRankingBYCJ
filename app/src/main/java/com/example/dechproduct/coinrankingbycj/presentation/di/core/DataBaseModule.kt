package com.example.dechproduct.coinrankingbycj.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.dechproduct.coinrankingbycj.data.db.CoinDao
import com.example.dechproduct.coinrankingbycj.data.db.CoinDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideCoinDataBase(context: Context): CoinDatabase {
        return Room.databaseBuilder(context, CoinDatabase::class.java,"coinclient").build()
    }

    @Singleton
    @Provides
    fun providesCoinDao(coinDatabase: CoinDatabase):CoinDao {
        return coinDatabase.coinDao()
    }

}
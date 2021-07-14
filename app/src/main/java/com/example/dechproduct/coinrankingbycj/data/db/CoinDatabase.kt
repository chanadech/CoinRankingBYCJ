package com.example.dechproduct.coinrankingbycj.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dechproduct.coinrankingbycj.data.model.Coin

@Database(entities = [Coin::class], version = 1, exportSchema = false)
abstract class CoinDatabase : RoomDatabase(){

    abstract fun coinDao(): CoinDao
}
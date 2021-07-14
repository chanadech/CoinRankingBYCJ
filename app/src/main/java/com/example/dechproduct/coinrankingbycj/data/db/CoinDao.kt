package com.example.dechproduct.coinrankingbycj.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dechproduct.coinrankingbycj.data.model.Coin

@Dao
interface CoinDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCoins(coins: List<Coin>)

    @Query("DELETE FROM coins_data")
    suspend fun deleteAllCoins()

    @Query("SELECT * FROM coins_data")
    suspend fun getCoins():List<Coin>
}
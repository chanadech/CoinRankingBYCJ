package com.example.dechproduct.coinrankingbycj.data.model


import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "coins_data")
data class Coin(

    @SerializedName("description")
    val description: String,

    @SerializedName("iconType")
    val iconType: String,

    @SerializedName("iconUrl")
    val iconUrl: String,

    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("price")
    val price: String,

    @SerializedName("rank")
    val rank: Int,

    @SerializedName("slug")
    val slug: String,

    @SerializedName("type")
    val type: String,

    @SerializedName("uuid")
    val uuid: String,

)
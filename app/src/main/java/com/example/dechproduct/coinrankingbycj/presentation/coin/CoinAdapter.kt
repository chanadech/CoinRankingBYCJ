package com.example.dechproduct.coinrankingbycj.presentation.coin

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.DataBindingUtil
import com.example.dechproduct.coinrankingbycj.R
import androidx.recyclerview.widget.RecyclerView
import coil.ImageLoader
import coil.decode.SvgDecoder
import coil.request.LoadRequest
import com.bumptech.glide.Glide
import com.example.dechproduct.coinrankingbycj.data.model.Coin
import com.example.dechproduct.coinrankingbycj.databinding.ListItemBinding
import com.squareup.picasso.Picasso

class CoinAdapter(private val context: Context) : RecyclerView.Adapter<CoinViewHolder>() {

    private val coinList = ArrayList<Coin>()

    fun setList(coins: List<Coin>) {
        coinList.clear()
        coinList.addAll(coins)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CoinViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false

        )
        return CoinViewHolder(binding, context)
    }

    override fun onBindViewHolder(holder: CoinViewHolder, position: Int) {
        holder.bind(coinList[position])
    }

    override fun getItemCount(): Int {
       return coinList.size
    }




}

class CoinViewHolder(val binding: ListItemBinding, private val context: Context  ) :
    RecyclerView.ViewHolder(binding.root) {

    val iconSize = context.resources.getDimension(R.dimen.icon_size).toInt()

    fun bind(coin: Coin) {
        binding.coinTitleTv.text = coin.name
        binding.coinDescTv.text = coin.description
        val imageURL = coin.iconUrl
        if(coin.iconUrl.contains(".svg")){
            coin.iconType == "vector"

        }

        if(coin.iconType == "vector"){


        } else {
            Glide.with(binding.coinImv.context)
                .load(imageURL)
                .into(binding.coinImv)
        }

    }



}

fun AppCompatImageView.loadSvg(myUrl: String?) {
    myUrl?.let {
        val imageLoader = ImageLoader.Builder(this.context)
            .componentRegistry {
                add(SvgDecoder(this@loadSvg.context))
            }
            .build()
        val request = LoadRequest.Builder(this.context)
            .data(it)
            .target(this)
            .build()
        imageLoader.execute(request)
    }
}








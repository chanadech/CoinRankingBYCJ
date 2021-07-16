package com.example.dechproduct.coinrankingbycj.presentation.coin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dechproduct.coinrankingbycj.R
import com.example.dechproduct.coinrankingbycj.databinding.ActivityCoinBinding
import com.example.dechproduct.coinrankingbycj.presentation.di.core.Injector
import javax.inject.Inject

class CoinActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: CoinViewModelFactory
    private lateinit var coinViewModel: CoinViewModel
    private lateinit var binding: ActivityCoinBinding
    private lateinit var adapter: CoinAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(
            this, R.layout.activity_coin)
        (application as Injector).createCoinSubComponent()
            .inject(this)

        coinViewModel = ViewModelProvider(this, factory)
            .get(CoinViewModel::class.java)

        initRecyclerView()

    }

    private fun initRecyclerView(){
        binding.coinRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CoinAdapter(this)
        binding.coinRecyclerView.adapter = adapter
        displayCoin()

    }

    private fun displayCoin(){
        binding.coinProgressBar.visibility = View.VISIBLE
        val responseLiveData = coinViewModel.getCoins()
        responseLiveData.observe(this, {
            if (it != null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.coinProgressBar.visibility = View.GONE
            } else {
                binding.coinProgressBar.visibility  = View.GONE
                Toast.makeText(applicationContext,"No data available", Toast.LENGTH_LONG).show()

            }
        })
    }

    //optional for update coin data

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater : MenuInflater = menuInflater
        inflater.inflate(R.menu.menu_item_update, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.action_update -> {
                updateCoins()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }

    }

    private fun updateCoins(){
        binding.coinProgressBar.visibility = View.VISIBLE
        val response = coinViewModel.updateCoins()
        response.observe(this, Observer {
            if(it!=null){
                adapter.setList(it)
                adapter.notifyDataSetChanged()
                binding.coinProgressBar.visibility = View.GONE
            }else{
                binding.coinProgressBar.visibility = View.GONE
            }
        })
    }

}
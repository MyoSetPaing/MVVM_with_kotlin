package com.myosetpaing.mvvmkotlin.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import com.myosetpaing.mvvmkotlin.R
import com.myosetpaing.mvvmkotlin.adapters.BeerRecyclerViewAdapter
import com.myosetpaing.mvvmkotlin.di.Injection
import com.myosetpaing.mvvmkotlin.viewModel.BeerViewModel
import com.myosetpaing.mvvmkotlin.viewModel.viewModelFactory.BeerViewModelFactory
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val mAdapter: BeerRecyclerViewAdapter by lazy { BeerRecyclerViewAdapter(this) }
    private val mViewModel: BeerViewModel by lazy {
        ViewModelProviders.of(this, BeerViewModelFactory(Injection.provideMainRepository(applicationContext)))
            .get(BeerViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvBeerList.apply {
            layoutManager = GridLayoutManager(applicationContext, 2)
            adapter = mAdapter
        }
        mViewModel.successState.observe(this, Observer {
            this.mAdapter.setData(it.toMutableList())
        })
        mViewModel.errorState.observe(this, Observer {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        })
        mViewModel.loadBeerList()
    }
}

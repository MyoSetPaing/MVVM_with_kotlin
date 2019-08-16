package com.myosetpaing.mvvmkotlin.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import com.myosetpaing.mvvmkotlin.R
import com.myosetpaing.mvvmkotlin.data.vos.BeersVO
import com.myosetpaing.mvvmkotlin.views.BeerViewHolder

class BeerRecyclerViewAdapter(val context: Context) : BaseRecyclerAdapter<BeerViewHolder, BeersVO>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BeerViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.item_view_beers, parent, false)
        return BeerViewHolder(itemView)
    }

}
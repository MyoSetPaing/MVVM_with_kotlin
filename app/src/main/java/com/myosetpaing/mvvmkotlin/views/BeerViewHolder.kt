package com.myosetpaing.mvvmkotlin.views

import android.view.View
import com.myosetpaing.mvvmkotlin.data.vos.BeersVO
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_view_beers.view.*

class BeerViewHolder(itemview: View) : BaseViewHolder<BeersVO>(itemview) {

    override fun setData(data: BeersVO) {
        itemView.apply {
            tvBeerName.text = data.name
            Picasso.get().load(data.image_url).into(itemView.ivBeer)
        }
    }

}
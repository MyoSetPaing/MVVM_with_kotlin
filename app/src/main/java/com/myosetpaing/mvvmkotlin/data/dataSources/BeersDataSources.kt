package com.myosetpaing.mvvmkotlin.data.dataSources

import androidx.lifecycle.MutableLiveData
import com.myosetpaing.mvvmkotlin.data.vos.BeersVO
import com.myosetpaing.mvvmkotlin.network.response.BeerResponse
import io.reactivex.Observable

interface BeersDataSources {
    var beersData: MutableLiveData<Observable<List<BeersVO>>>
    fun fetchBeerData()
    fun saveDataIntoDatabase(beerList: List<BeersVO>)
}
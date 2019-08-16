package com.myosetpaing.mvvmkotlin.network

import com.myosetpaing.mvvmkotlin.data.vos.BeersVO
import com.myosetpaing.mvvmkotlin.network.response.BeerResponse
import io.reactivex.Observable
import retrofit2.http.GET

interface BeerApi {

    @GET("v2/beers")
    fun loadBeersList(): Observable<List<BeersVO>>
}
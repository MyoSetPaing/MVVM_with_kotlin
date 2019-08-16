package com.myosetpaing.mvvmkotlin.data.repositories

import android.content.Context
import androidx.lifecycle.MutableLiveData
import com.myosetpaing.mvvmkotlin.Utils
import com.myosetpaing.mvvmkotlin.data.dataSources.BeersDataSources
import com.myosetpaing.mvvmkotlin.data.vos.BeersVO
import com.myosetpaing.mvvmkotlin.network.BeerApi
import com.myosetpaing.mvvmkotlin.network.response.BeerResponse
import com.myosetpaing.mvvmkotlin.persistence.MVVMDatabase
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class BeerRepoistory(
    private val context: Context,
    private val mBeerApi: BeerApi,
    private val database: MVVMDatabase
) : BeersDataSources {
    override var beersData: MutableLiveData<Observable<List<BeersVO>>> = MutableLiveData()

    override fun fetchBeerData() {
        if (Utils.isOnline(context)) {
            beersData.postValue(mBeerApi.loadBeersList())
        } else {
            val beerList = database.beerDao().getBeerList
            val disposable = CompositeDisposable()
            disposable.add(
                beerList
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .subscribe {
                        disposable.clear()
                        val responseData = it
                        beersData.postValue(Observable.just(responseData))
                    }
            )
        }
    }

    override fun saveDataIntoDatabase(beerList: List<BeersVO>) {
        Observable.fromCallable { database.beerDao().insertAll(beerList) }
            .subscribeOn(Schedulers.io())
            .observeOn(Schedulers.io())
            .subscribe()
    }

}
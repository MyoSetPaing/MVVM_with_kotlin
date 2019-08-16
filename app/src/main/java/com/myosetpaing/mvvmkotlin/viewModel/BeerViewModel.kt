package com.myosetpaing.mvvmkotlin.viewModel

import androidx.lifecycle.MutableLiveData
import com.myosetpaing.mvvmkotlin.data.dataSources.BeersDataSources
import com.myosetpaing.mvvmkotlin.data.vos.BeersVO

import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class BeerViewModel(private val beersDataSources: BeersDataSources) : BaseViewModel() {

    var errorState = MutableLiveData<String>()
    var successState = MutableLiveData<List<BeersVO>>()

    fun loadBeerList() {
        beersDataSources.beersData.observeForever {
            launch {
                it.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .doOnNext {
                        beersDataSources.saveDataIntoDatabase(it)
                    }
                    .subscribe({
                        beersDataSources.beersData = MutableLiveData()
                        successState.postValue(it)
                    }, {
                        errorState.postValue(it.localizedMessage)
                    })
            }
        }
        beersDataSources.fetchBeerData()
    }

}
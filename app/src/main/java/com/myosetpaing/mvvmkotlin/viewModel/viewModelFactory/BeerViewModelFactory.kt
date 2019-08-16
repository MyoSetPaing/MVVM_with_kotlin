package com.myosetpaing.mvvmkotlin.viewModel.viewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.myosetpaing.mvvmkotlin.data.dataSources.BeersDataSources
import com.myosetpaing.mvvmkotlin.data.repositories.BeerRepoistory
import com.myosetpaing.mvvmkotlin.viewModel.BeerViewModel

class BeerViewModelFactory(val dataSource: BeersDataSources) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return BeerViewModel(dataSource) as T
    }

}
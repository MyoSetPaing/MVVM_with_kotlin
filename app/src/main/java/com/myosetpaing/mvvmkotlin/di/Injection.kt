package com.myosetpaing.mvvmkotlin.di

import android.content.Context
import com.google.gson.Gson
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.myosetpaing.mvvmkotlin.AppConstants
import com.myosetpaing.mvvmkotlin.data.dataSources.BeersDataSources
import com.myosetpaing.mvvmkotlin.data.repositories.BeerRepoistory
import com.myosetpaing.mvvmkotlin.network.BeerApi
import com.myosetpaing.mvvmkotlin.persistence.MVVMDatabase
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Injection {
    private fun provideApiService(): BeerApi {
        val okHttpClient = OkHttpClient.Builder()
            .connectTimeout(60, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .readTimeout(60, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(AppConstants.base_url)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
        return retrofit.create(BeerApi::class.java)
    }

    private fun provideDatabase(context: Context): MVVMDatabase {
        return MVVMDatabase.getInstance(context)
    }

    fun provideMainRepository(context: Context): BeersDataSources {
        return BeerRepoistory(context, provideApiService(), provideDatabase(context))
    }
}
package com.myosetpaing.mvvmkotlin.persistence.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.myosetpaing.mvvmkotlin.data.vos.BeersVO
import io.reactivex.Observable

@Dao
interface BeerDao {
    @get:Query("select * from beer")
    val getBeerList: Observable<List<BeersVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<BeersVO>)
}
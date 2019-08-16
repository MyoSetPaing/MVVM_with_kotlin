package com.myosetpaing.mvvmkotlin.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.myosetpaing.mvvmkotlin.data.vos.BeersVO
import com.myosetpaing.mvvmkotlin.persistence.dao.BeerDao


@Database(entities = [BeersVO::class], version = 1, exportSchema = false)
abstract class MVVMDatabase : RoomDatabase() {
    abstract fun beerDao(): BeerDao

    companion object {
        private var instance: MVVMDatabase? = null

        fun getInstance(context: Context): MVVMDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, MVVMDatabase::class.java, "MVVMDatabase")
                    .build()
            }
            return instance as MVVMDatabase
        }
    }
}
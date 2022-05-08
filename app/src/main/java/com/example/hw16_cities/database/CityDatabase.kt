package com.example.hw16_cities.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [CityEntity::class],version = 1)
abstract class CityDatabase:RoomDatabase() {
    abstract fun cityDao(): DaoOfCityEntity
    companion object{
    var     INSTANCE: CityDatabase? = null
        fun getDatabase(context: Context): CityDatabase?{
            if (INSTANCE == null){
                synchronized(CityDatabase::class){
                    INSTANCE = Room.databaseBuilder(context.applicationContext,
                        CityDatabase::class.java,"myDb")
                        .allowMainThreadQueries().build()
                }
            }
            return INSTANCE
        }
    }
}
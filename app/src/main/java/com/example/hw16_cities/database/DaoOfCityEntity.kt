package com.example.hw16_cities.database

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface DaoOfCityEntity {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg questions: CityEntity)

    @Query("Select * from CityEntity where cityName = :name")
    fun getCity(name:String):CityEntity


    @Query("Select * From CityEntity")
    fun getList(): LiveData<List<CityEntity>>


//    @Query("select * from CityEntity where isSelected = :selection")
//    fun getSelectedCityList(selection:Boolean): LiveData<List<CityEntity>>

    @Query("SELECT  count(id) FROM CityEntity")
    fun getICityNumber():Int

    @Update
    fun edit(city: CityEntity)



}
package com.example.hw16_cities

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.hw16_cities.database.CityDatabase
import com.example.hw16_cities.database.CityEntity
import com.example.hw16_cities.database.DaoOfCityEntity

class Repository {

    var db: CityDatabase? = null
    var cityDao: DaoOfCityEntity? = null
    fun initDB(context: Context){
        db = CityDatabase.getDatabase(context)
        cityDao = db?.cityDao()
    }
    var citiesList = listOf(City("Esfehan"),City("Shiraz"),City("Tehran"),City("Mahalat"),City("Kashan"),
                                    City("qazvin"),City("Sari"),City("Bam"),City("Hamedan"),City("Rasht"))


    fun addCity(city: CityEntity){
        db!!.cityDao().addCity(city)
    }
    fun getList(): LiveData<List<CityEntity>>{
        return db!!.cityDao().getList()
    }
    fun delete(city: String){
        db!!.cityDao().deleteItem (city)
    }
}
class City(var name:String){
    var isSelected = false
}

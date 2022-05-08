package com.example.hw16_cities

import android.content.Context
import com.example.hw16_cities.database.CityDatabase
import com.example.hw16_cities.database.DaoOfCityEntity

class Repository {

    var db: CityDatabase? = null
    var cityDao: DaoOfCityEntity? = null
    fun initDB(context: Context){
        db = CityDatabase.getDatabase(context)
        cityDao = db?.cityDao()
    }
    var citiesList = listOf<City>(City("Esfehan"),City("Shiraz"),City("Tehran"),City("Mahalat"),City("Kashan"),
                                    City("qazvin"),City("Sari"),City("Bam"),City("Hamedan"),City("Rasht"))


    fun addCity(city: City){
        db!!.cityDao().addCity(city)
    }
}
class City(var name:String){
    var isSelected = false
}

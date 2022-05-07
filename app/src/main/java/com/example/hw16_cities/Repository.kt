package com.example.hw16_cities

import android.content.Context

class Repository {

    var db: CityDatabase? = null
    var cityDao: DaoOfCityEntity? = null
    fun initDB(context: Context){
        db = CityDatabase.getDatabase(context)
        cityDao = db?.cityDao()
    }
    var citiesList = listOf<City>(City("Esfehan"),City("Shiraz"),City("Tehran"),City("Mahalat"),City("Kashan"),
                                    City("qazvin"),City("Sari"),City("Bam"),City("Hamedan"),City("Rasht"))
}
class City(var name:String){
    var isSelected = false
}

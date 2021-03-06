package com.example.hw16_cities

import android.content.Context
import androidx.lifecycle.LiveData
import com.example.hw16_cities.database.*

class Repository {

    var db: CityDatabase? = null
    var cityDao: DaoOfCityEntity? = null
    var selectedCityDoa:DaoOfSelectedCity? = null
    fun initDB(context: Context){
        db = CityDatabase.getDatabase(context)
        cityDao = db?.cityDao()
        selectedCityDoa = db?.selectedCityDao()

        if(getSizeList() == 0){
            addTenCity()
        }

    }

    private fun addTenCity() {
        cityDao?.insertAll(CityEntity(0,"Esfehan",false), CityEntity(0,"Shiraz",false),
                           CityEntity(0,"Tehran",false), CityEntity(0,"Mahalat",false),
                           CityEntity(0,"Kashan",false), CityEntity(0,"qazvin",false),
                           CityEntity(0,"Sari",false), CityEntity(0,"Bam",false),
                           CityEntity(0,"Hamedan",false), CityEntity(0,"Rasht",false))
    }


    fun getSizeList():Int{
        return db!!.cityDao().getICityNumber()
    }
    fun getCity(name: String):CityEntity{
        return db!!.cityDao().getCity(name)
    }
    fun addCity(city: SelectedCityEntity){
        db!!.selectedCityDao().addCity(city)
    }
    fun getList(): LiveData<List<CityEntity>>{
        return db!!.cityDao().getList()
    }
    fun delete(city: String){
        db!!.selectedCityDao().deleteItem (city)
    }
//    fun getSelectedCitiesList(selection:Boolean): LiveData<List<CityEntity>>{
//        return db!!.cityDao().getSelectedCityList(selection)
//    }
    fun getSelectedCitiesList(): LiveData<List<SelectedCityEntity>>{
        return db!!.selectedCityDao().getList()
    }

    fun update(city: CityEntity){
        db!!.cityDao().edit(city)
    }
}


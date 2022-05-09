package com.example.hw16_cities

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.hw16_cities.database.CityEntity

class HomeViewModel(app: Application): AndroidViewModel(app)  {
    var citiesListLD : LiveData<List<CityEntity>>
    var selectedCitiesListLD : LiveData<List<CityEntity>>
    var repo = Repository()
    init {
        repo.initDB(app.applicationContext)
        citiesListLD = repo.getList()
        selectedCitiesListLD = getSelectedCityList(true)


    }
//    fun selectCity(city: CityEntity){
//        repo.addCity(city)
//    }
//    fun delete(city: String){
//        repo.delete(city)
//    }
    fun getSelectedCityList(selection:Boolean): LiveData<List<CityEntity>> {
    return repo.getSelectedCitiesList(selection)
    }
    fun update(city: CityEntity){
        repo.update(city)
    }
}
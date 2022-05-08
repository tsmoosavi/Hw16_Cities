package com.example.hw16_cities

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class HomeViewModel(app: Application): AndroidViewModel(app)  {


    var repo = Repository()
    var listOfCity = repo.citiesList
 init {
     repo.initDB(app.applicationContext)
 }
    fun selectCity(city: City){
        repo.addCity(city)
    }
}
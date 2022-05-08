package com.example.hw16_cities

import androidx.lifecycle.ViewModel

class ListViewModel: ViewModel()  {
    var x = Repository().citiesList
}
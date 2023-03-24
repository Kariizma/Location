package com.example.location.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.location.api.RetrofitInstance
import com.example.location.models.CountriesItem
import kotlinx.coroutines.launch

class LocationViewModel : ViewModel() {
    private val _listOfCountries = MutableLiveData<List<CountriesItem>>()
    val listOfCountries: LiveData<List<CountriesItem>> = _listOfCountries

    init {
        getCountries()
    }

    private fun getCountries() {
        viewModelScope.launch {
            try {
                _listOfCountries.value = RetrofitInstance.api.getCountries()
                Log.v("getUsersInfo()", "Success!")
            } catch (e: Exception) {
                Log.e("getUsersInfo()", "Failure: ${e.message}")
                _listOfCountries.value = listOf()
            }
        }
    }
}
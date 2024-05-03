package com.example.dogbreedsapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dogbreedsapplication.api.RetrofitInstance
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class BreedViewModel :ViewModel(){

    val viewModelScope = CoroutineScope(Dispatchers.IO)
    private val _text = MutableLiveData<String>().apply {
        value = "Dog Info"
    }

    val text:LiveData<String> = _text

    init{
        getDogBreedList()
    }

    fun getDogBreedList(){
        viewModelScope.launch {
            val result = RetrofitInstance.apiClient.getMessages2()

            if(!result.isNotEmpty()){
//                _text.postValue()
            }

        }
    }

}
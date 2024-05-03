package com.example.dogbreedsapplication.ui.breed_list

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dogbreedsapplication.data.api.RetrofitInstance
import kotlinx.coroutines.launch

class BreedListViewModel:ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dog breed fragment"
    }

    val text: LiveData<String> = _text

    init {
        getDogBreeds()
    }

    fun getDogBreeds(){
        var breeds:MutableList<Any> = mutableListOf() //the list of breeds I'm extracting from API response

        viewModelScope.launch {
            val resultMap = RetrofitInstance.apiClient.getDogBreed2()

            if (!resultMap.isNullOrEmpty()){

                //just return back 1 entry
                for(entry in resultMap){

                    if(entry.value is Map<*, *>){
                        for(nestedKeys in (entry.value as Map<*, *>).keys){
                            breeds.add(nestedKeys.toString())
                            Log.d("MainActivity", "${entry.key}: ${entry.value}") //Log all key/value entries in messages
                            Log.d("Keys",nestedKeys.toString()) //Log out the specific breed name
                        }
                    }
                }


                _text.postValue(breeds[0].toString())
            }
        }
    }




}
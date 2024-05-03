package com.example.dogbreedsapplication

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dogbreedsapplication.api.RetrofitInstance
import com.example.dogbreedsapplication.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

class MainActivity : AppCompatActivity() {

    //create binding variable to make access to UI elements easier to reference
    private lateinit var binding:ActivityMainBinding
    private lateinit var viewModel:BreedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val breedViewModel = ViewModelProvider(this).get(BreedViewModel::class.java)

        //initialize the binding variable by inflating the view
        binding = ActivityMainBinding.inflate(layoutInflater)

        //set contentView to binding root
        setContentView(binding.root)

        val textView:TextView = binding.textView
        textView.setOnClickListener {


        }
//        breedViewModel.text.observe(this, Observer {
//            textView.text = it
//        })


        //Connect to the API and display the dog breeds in the UI using RecyclerView (activity_main.xml)
//        GlobalScope.launch {

        runBlocking {

            binding.textView.setText(getDogBreeds().toString())
        }

        binding.apply {

        }

//            Log.d("MainActivity","${getMessages()}")
//            Log.d("MainActivity","${getMessages2()}")
//            getMessages2()

//        }


    }

    private suspend fun getDogBreeds():List<Any>{
        var breeds:MutableList<Any> = mutableListOf() //the list of breeds I'm extracting from API response
        var resultMap:Map<String,Any?> = emptyMap() //this will return map of results obtained

       return GlobalScope.async{
            resultMap = RetrofitInstance.apiClient.getDogBreed2()

            for(entry in resultMap){

                if(entry.value is Map<*, *>){
                    for(nestedKeys in (entry.value as Map<*, *>).keys){
                        breeds.add(nestedKeys.toString())
                        Log.d("MainActivity", "${entry.key}: ${entry.value}") //Log all key/value entries in messages
                        Log.d("Keys",nestedKeys.toString()) //Log out the specific breed name
                    }
                }
            }
           breeds//return the result directly
        }.await() //wait for async task to complete and return its result

     //return result

    }

}
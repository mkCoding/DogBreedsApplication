package com.example.dogbreedsapplication.api

import com.example.dogbreedsapplication.model.DogBreed
import com.example.dogbreedsapplication.model.Message
import retrofit2.http.GET

interface ApiEndpoints {
    @GET(ApiDetail.DOG_BREED_ENDPOINT)
    suspend fun getDogBreed(): ArrayList<DogBreed>  //this is the array list associated with each dog breed

        @GET(ApiDetail.DOG_BREED_ENDPOINT)
        suspend fun getMessage(): Message //this is the message Object which consisting of dog breeds variables

    @GET(ApiDetail.DOG_BREED_ENDPOINT)
    suspend fun getMessages2():Map<String,Any>
}
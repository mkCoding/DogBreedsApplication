package com.example.dogbreedsapplication.data.api

import com.example.dogbreedsapplication.data.model.DogBreedModel
import com.example.dogbreedsapplication.data.model.MessageModel
import retrofit2.http.GET

interface ApiEndpoints {
    @GET(ApiDetail.DOG_BREED_ENDPOINT)
    suspend fun getDogBreed(): ArrayList<DogBreedModel>  //this is the array list associated with each dog breed

    @GET(ApiDetail.DOG_BREED_ENDPOINT)
    suspend fun getMessage(): MessageModel //this is the message Object which consisting of dog breeds variables

    @GET(ApiDetail.DOG_BREED_ENDPOINT)
    suspend fun getDogBreed2():Map<String,Any>
}
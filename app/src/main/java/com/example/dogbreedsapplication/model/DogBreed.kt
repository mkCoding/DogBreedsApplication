package com.example.dogbreedsapplication.model


import com.google.gson.annotations.SerializedName

data class DogBreed(
    @SerializedName("message")
    val message: Message? = Message(),
    @SerializedName("status")
    val status: String? = ""
)
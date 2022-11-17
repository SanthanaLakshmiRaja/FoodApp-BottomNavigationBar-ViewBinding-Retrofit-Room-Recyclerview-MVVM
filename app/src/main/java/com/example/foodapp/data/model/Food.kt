package com.example.foodapp.data.model


import com.google.gson.annotations.SerializedName

data class Food(

    @SerializedName("idMeal")
    val id: String?,

    @SerializedName("strMeal")
    val name: String?,

    @SerializedName("strMealThumb")
    val imageLink: String?

)
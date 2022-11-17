package com.example.foodapp.data.model

import com.google.gson.annotations.SerializedName

data class Category(

    @SerializedName("strCategory")
    val name: String?,

    @SerializedName("strCategoryThumb")
    val imageLink: String?

)
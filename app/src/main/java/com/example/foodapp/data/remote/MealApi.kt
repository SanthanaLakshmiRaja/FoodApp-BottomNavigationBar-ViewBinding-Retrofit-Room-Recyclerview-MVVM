package com.example.foodapp.data.remote

import com.example.foodapp.data.model.CategoryList
import com.example.foodapp.data.model.FoodList
import com.example.foodapp.data.model.MealList
import com.example.foodapp.util.Constants.Companion.END_POINT_CATEGORIES
import com.example.foodapp.util.Constants.Companion.END_POINT_FILTER
import com.example.foodapp.util.Constants.Companion.END_POINT_LOOKUP
import com.example.foodapp.util.Constants.Companion.END_POINT_SEARCH
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MealApi {

    @GET(END_POINT_FILTER)
    fun getFoodsByCategory(@Query("c") categoryName: String): Call<FoodList>

    @GET(END_POINT_CATEGORIES)
    fun getCategories(): Call<CategoryList>

    @GET(END_POINT_LOOKUP)
    fun getMealById(@Query("i") id: String): Call<MealList>

    @GET(END_POINT_SEARCH)
    fun getMealByName(@Query("s") mealName: String): Call<MealList>

}
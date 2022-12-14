package com.example.foodapp.viewmodel


import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.model.FoodList
import com.example.foodapp.data.remote.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel : ViewModel() {

    private val foods =MutableLiveData<FoodList>()

    fun getFoodsByCategory(categoryName: String) {

        RetrofitInstance.mealApi.getFoodsByCategory(categoryName).enqueue(object : Callback<FoodList> {

            override fun onResponse(call: Call<FoodList>, response: Response<FoodList>) {
                foods.value = response.body()
            }

            override fun onFailure(call: Call<FoodList>, t: Throwable) {
                Log.e("Error: ", t.message.toString())
            }

        })

    }

    fun observeFoods(): LiveData<FoodList> {
        return foods
    }

}
package com.example.foodapp.viewmodel



import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.data.model.Meal
import com.example.foodapp.data.model.MealList
import com.example.foodapp.data.remote.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SearchViewModel: ViewModel() {

    private var meal = MutableLiveData<Meal>()

    fun getMealByName(mealName: String, context: Context?) {

        RetrofitInstance.mealApi.getMealByName(mealName).enqueue(object : Callback<MealList> {

            override fun onResponse(call: Call<MealList>, response: Response<MealList>) {

                if (response.body()?.meals == null) Toast.makeText(context?.applicationContext,"no_meal_found_with_that_name_try_another", Toast.LENGTH_SHORT).show()
                else meal.value = response.body()!!.meals[0]

            }

            override fun onFailure(call: Call<MealList>, t: Throwable) {
                Log.e("Error: ", t.message.toString())
            }

        })

    }

    fun observeMeal(): LiveData<Meal> {
        return meal
    }

}
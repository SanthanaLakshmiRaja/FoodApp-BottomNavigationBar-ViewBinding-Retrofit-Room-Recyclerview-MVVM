package com.example.foodapp.data.remote

import com.example.foodapp.util.Constants.Companion.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {

    val mealApi: MealApi by lazy{

        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MealApi::class.java)
        /*We are creating an instance of the Retrofit Builder class.
        Then we are adding the base URL i.e. “https://simplifiedcoding.net/demos/”.
        Then adding the converter factory as a Gson converter factory( It converts Java/kotlin objects to JSON and vice versa).
        And at last, we are calling the build method.
        Part 2

        We are calling the create method for the interface that we created earlier.

        Part 3

        Firstly we are calling the getHero() function from the interface
        Then calling the enqueue function which will override two methods – onResponse and onFailure
                In onResponse, we will write up for the response using the ‘response.body()’ method
        In onFailure, we will handle up for any failure like – There is no Internet.
        Part Extra*/

    }

}
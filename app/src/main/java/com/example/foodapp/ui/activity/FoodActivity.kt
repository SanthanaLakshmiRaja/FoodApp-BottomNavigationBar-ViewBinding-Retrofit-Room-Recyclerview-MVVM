package com.example.foodapp.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.adapters.FoodAdapter
import com.example.foodapp.data.model.Food
import com.example.foodapp.databinding.ActivityFoodBinding
import com.example.foodapp.util.Constants.Companion.CATEGORY
import com.example.foodapp.util.Constants.Companion.ID
import com.example.foodapp.viewmodel.FoodViewModel



class FoodActivity : AppCompatActivity() {

    private lateinit var foodViewModel: FoodViewModel
    private lateinit var foodAdapter: FoodAdapter
    private lateinit var binding: ActivityFoodBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        foodViewModel = ViewModelProvider(this)[FoodViewModel::class.java]

        setUpRecyclerView()
        getFoodsByCategory()
        observeFoods()
        setOnClickMaterialCardView()
        showProgressBar()

    }

    private fun setUpRecyclerView() {

        binding.mRecyclerView.apply {
            foodAdapter = FoodAdapter()
            adapter = foodAdapter
        }

    }

    private fun getFoodsByCategory() {

        foodViewModel.getFoodsByCategory(intent.getStringExtra(CATEGORY)!!)

    }

    private fun observeFoods() {

        foodViewModel.observeFoods().observe(this) {

            foodAdapter.setFoods(it!!.meals)
            hideProgressBar()

        }

    }

    private fun setOnClickMaterialCardView() {

        foodAdapter.setOnClickMaterialCardView(object : FoodAdapter.OnClickMaterialCardView {

            override fun onClick(food: Food) {

                val intent = Intent(applicationContext, DetailActivity::class.java)
                intent.putExtra(ID, food.id)
                startActivity(intent)

            }

        })

    }

    private fun showProgressBar() {

        binding.mProgressBar.visibility = View.VISIBLE

    }

    private fun hideProgressBar() {

        binding.mProgressBar.visibility = View.GONE

    }

}
package com.example.foodapp.ui.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.adapters.HomeAdapter
import com.example.foodapp.databinding.FragmentHomeBinding
import com.example.foodapp.ui.activity.DetailActivity
import com.example.foodapp.data.model.Food
import com.example.foodapp.util.Constants.Companion.ID
import com.example.foodapp.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var homeAdapter: HomeAdapter
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // The system calls this method when creating the fragment. You should initialize essential components of the fragment that you want to retain when the fragment is paused or stopped, then resumed.
        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        homeAdapter = HomeAdapter()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       // onCreateView is used in fragment to create layout and inflate view. onViewCreated is used to reference the view created by above method. Lastly it is a good practice to define action listener in onActivityCreated
        setUpRecyclerView()
        getFoodsByCategory()
        observeFoods()
        setOnClickMaterialCardView()
        showProgressBar()

    }

    override fun onDestroyView() {
       // onDestroy() of super should be called once u have done with your clean up handling.
        super.onDestroyView()
       // System calls this method to clean up all kinds of resources as well as view hierarchy associated with the fragment.
        _binding = null
    }

    private fun setUpRecyclerView() {

        binding.mRecyclerView.apply {

            adapter = homeAdapter
        }

    }

    private fun getFoodsByCategory() {

        //homeViewModel.getFoodsByCategory("beef")
        homeViewModel.getFoodsByCategory("Vegetarian")


    }

    private fun observeFoods() {

        homeViewModel.observeFoods().observe(viewLifecycleOwner) {
            homeAdapter.setFoods(it!!.meals)
            hideProgressBar()
        }

    }

    private fun setOnClickMaterialCardView() {

        homeAdapter.setOnClickMaterialCardView(object : HomeAdapter.OnClickMaterialCardView {

            override fun onClick(food: Food) {

                val intent = Intent(activity, DetailActivity::class.java)
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
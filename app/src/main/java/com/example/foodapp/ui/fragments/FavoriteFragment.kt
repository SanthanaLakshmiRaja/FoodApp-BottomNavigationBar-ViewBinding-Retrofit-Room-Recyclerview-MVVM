package com.example.foodapp.ui.fragments


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.foodapp.adapters.FavoriteAdapter
import com.example.foodapp.databinding.FragmentFavoriteBinding
import com.example.foodapp.ui.activity.DetailActivity
import com.example.foodapp.data.model.Favorite
import com.example.foodapp.util.Constants.Companion.ID
import com.example.foodapp.viewmodel.FavoriteViewModel


class FavoriteFragment : Fragment() {

    private lateinit var favoriteViewModel: FavoriteViewModel
    private lateinit var favoriteAdapter: FavoriteAdapter
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        favoriteViewModel = ViewModelProvider(this)[FavoriteViewModel::class.java]
        favoriteAdapter = FavoriteAdapter()

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setUpRecyclerView()
        observeFavorites()
        setOnClickMaterialCardView()

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setUpRecyclerView() {

        binding.mRecyclerView.apply {
            adapter = favoriteAdapter
        }

    }

    private fun observeFavorites() {

        favoriteViewModel.observeFavorites().observe(viewLifecycleOwner) {

            favoriteAdapter.setFavorites(it)
            if (it.isEmpty()) binding.mTextView.visibility = View.VISIBLE
            else binding.mTextView.visibility = View.GONE

        }

    }

    private fun setOnClickMaterialCardView() {

        favoriteAdapter.setOnClickMaterialCardView(object : FavoriteAdapter.OnClickMaterialCardView {

            override fun onClick(favorite: Favorite) {

                val intent = Intent(context, DetailActivity::class.java)
                intent.putExtra(ID, favorite.id.toString())
                startActivity(intent)

            }

        })

    }

}
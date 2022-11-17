package com.example.foodapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.foodapp.data.database.FavoriteDatabase
import com.example.foodapp.data.database.FavoriteRepository
import com.example.foodapp.data.model.Favorite



class FavoriteViewModel(application: Application) : AndroidViewModel(application) {

    private var favoriteRepository: FavoriteRepository
    private var favorites: LiveData<List<Favorite>>

    init {

        val favoriteDao = FavoriteDatabase.getInstance(application).favoriteDao()
        favoriteRepository = FavoriteRepository(favoriteDao)
        favorites = favoriteRepository.getAllFavorites

    }

    fun observeFavorites(): LiveData<List<Favorite>> {
        return favorites
    }

}
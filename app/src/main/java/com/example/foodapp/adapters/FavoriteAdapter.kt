package com.example.foodapp.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.foodapp.R
import com.example.foodapp.databinding.ItemFavoriteBinding
import com.example.foodapp.data.model.Favorite


class FavoriteAdapter: RecyclerView.Adapter<FavoriteAdapter.MyFavoriteViewHolder>() {

    private var favorites: List<Favorite> = ArrayList()
    private lateinit var onClickMaterialCardView: OnClickMaterialCardView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyFavoriteViewHolder {
        return MyFavoriteViewHolder(ItemFavoriteBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(myFavoriteViewHolder: MyFavoriteViewHolder, position: Int) {

        val favorite = favorites[position]

        myFavoriteViewHolder.binding.apply {

            mImageView.load(favorite.imageLink) {
                placeholder(R.color.purple_200)
                error(R.color.purple_200)
            }
            mTextViewName.text = favorite.name

        }

        myFavoriteViewHolder.binding.mMaterialCardView.setOnClickListener {
            onClickMaterialCardView.onClick(favorite)
        }

    }

    override fun getItemCount(): Int {
        return favorites.size
    }

    class MyFavoriteViewHolder(val binding: ItemFavoriteBinding): RecyclerView.ViewHolder(binding.root)


    fun setFavorites(favorites: List<Favorite>) {
        this.favorites = favorites
        notifyDataSetChanged()
    }

    fun setOnClickMaterialCardView(onClickMaterialCardView: OnClickMaterialCardView) {
        this.onClickMaterialCardView = onClickMaterialCardView
    }

    interface OnClickMaterialCardView {
        fun onClick(favorite: Favorite)
    }

}
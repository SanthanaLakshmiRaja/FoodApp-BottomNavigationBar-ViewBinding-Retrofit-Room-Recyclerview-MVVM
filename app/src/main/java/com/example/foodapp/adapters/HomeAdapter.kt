package com.example.foodapp.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import coil.load
import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.R
import com.example.foodapp.databinding.ItemHomeBinding
import com.example.foodapp.data.model.Food



class HomeAdapter: RecyclerView.Adapter<HomeAdapter.MyHomeViewHolder>() {

    private var foods: List<Food> = ArrayList()
    private lateinit var onClickMaterialCardView: OnClickMaterialCardView
//It will convert the
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyHomeViewHolder {
        return MyHomeViewHolder(ItemHomeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(myHomeViewHolder: MyHomeViewHolder, position: Int) {

        val food = foods[position]

        myHomeViewHolder.binding.apply {

            mImageView.load(food.imageLink) {
                placeholder(R.color.purple_200)
                error(R.color.purple_200)

            }
            mTextViewName.text = food.name

        }

        myHomeViewHolder.binding.mMaterialCardView.setOnClickListener {
            onClickMaterialCardView.onClick(food)
        }

    }

    override fun getItemCount(): Int {
        return foods.size
    }

    class MyHomeViewHolder(val binding: ItemHomeBinding): RecyclerView.ViewHolder(binding.root)

    fun setFoods(foods: List<Food>) {
        this.foods = foods
        notifyDataSetChanged()
    }

    fun setOnClickMaterialCardView(onClickMaterialCardView: OnClickMaterialCardView) {
        this.onClickMaterialCardView = onClickMaterialCardView
    }

    interface OnClickMaterialCardView {
        fun onClick(food: Food)
    }

}
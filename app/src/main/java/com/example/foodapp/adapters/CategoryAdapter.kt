package com.example.foodapp.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.foodapp.R
import com.example.foodapp.databinding.ItemCategoryBinding
import com.example.foodapp.data.model.Category


class CategoryAdapter: RecyclerView.Adapter<CategoryAdapter.MyCategoryViewHolder>() {

    private var categories: List<Category> = ArrayList()
    private lateinit var onClickMaterialCardView: OnClickMaterialCardView

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyCategoryViewHolder {
        return MyCategoryViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(myCategoryViewHolder: MyCategoryViewHolder, position: Int) {

        val category = categories[position]

        myCategoryViewHolder.binding.apply {

            mImageView.load(category.imageLink) {
                placeholder(R.color.purple_200)
                error(R.color.purple_200)

            }
            mTextViewName.text = category.name

        }

        myCategoryViewHolder.binding.mMaterialCardView.setOnClickListener {
            onClickMaterialCardView.onClick(category)
        }

    }

    override fun getItemCount(): Int {
        return categories.size
    }

    class MyCategoryViewHolder(val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun setCategories(categories: List<Category>) {
        this.categories = categories
        notifyDataSetChanged()
    }

    fun setOnClickMaterialCardView(onClickMaterialCardView: OnClickMaterialCardView) {
        this.onClickMaterialCardView = onClickMaterialCardView
    }

    interface OnClickMaterialCardView {
        fun onClick(category: Category)
    }

}
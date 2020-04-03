package com.example.hackathonapp.components

import android.content.Context
import android.graphics.Color
import androidx.cardview.widget.CardView
import com.example.hackathonapp.R
import com.example.hackathonapp.utils.loadImageFromUrl
import kotlinx.android.synthetic.main.item_product.view.*

class ProductCardView(context: Context): CardView(context) {

	init {
	    inflate(context, R.layout.item_product, this)

	}

	fun setProductName(name: String) {
		tvProductName.text = name
	}

	fun setProductDescription(description: String) {
		tvProductDescription.text = description
	}

	fun setProductImage(description: String) {
		ivProduct.loadImageFromUrl(description)
	}

	fun setProductValue(value: String) {
		tvProductValue.text = value
	}

}

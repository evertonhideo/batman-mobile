package com.example.marketitiplace

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.bumptech.glide.Glide
import android.widget.ImageView
import android.widget.TextView
import br.com.zup.beagle.utils.toView
import br.com.zup.beagle.view.BeagleActivity
import br.com.zup.beagle.view.ScreenRequest
import br.com.zup.beagle.widget.ui.NetworkImage


class ProductComponent: LinearLayout {

    constructor (context: Context): super(context)

    constructor (context: Context , attrs: AttributeSet): super(context, attrs)


    init {
        inflate(context, R.layout.product_view, this)


    }

    fun setName(name: String, shortDescription: String, imageUrl: String, price: String) {
        findViewById<TextView>(R.id.tvName).text = name
        findViewById<TextView>(R.id.tvShortDescription).text = shortDescription
        findViewById<TextView>(R.id.tvPrice).text = price

//        NetworkImage(path = imageUrl).toView(context)


        val imageView = findViewById<ImageView>(R.id.my_image_view)
        Glide.with(imageView)
            .load(imageUrl)
            .into(imageView)
    }

    fun setOnClick(sku: String) {
        setOnClickListener {
            val request = ScreenRequest("/product/$sku")
            val intent = BeagleActivity.newIntent(context, request)
            context.startActivity(intent)
        }
    }

}

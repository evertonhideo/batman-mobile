package com.example.marketitiplace.widgets

import android.content.Context
import android.view.View
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.WidgetView
import com.example.marketitiplace.ProductComponent

@RegisterWidget
data class ProductWidget(
    val ID: String,
    val sku: String,
    val name: String,
    val shortDescription: String,
    val longDescription: String,
    val imageUrl: String,
    val price: String
) : WidgetView() {

    override fun toView(context: Context): View = ProductComponent(context).apply {
        setName(name, shortDescription, imageUrl, price)
        setOnClick(sku)
    }
}
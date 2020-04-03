package com.example.hackathonapp.widgets

import android.content.Context
import android.view.View
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.WidgetView
import br.com.zup.beagle.widget.form.InputWidget
import com.example.hackathonapp.components.ProductCardView

@RegisterWidget
data class ProductCard(
	val name: String = "",
	val description: String = "",
	val image: String = "",
	val value: String = ""
) : WidgetView() {
	override fun toView(context: Context): View {
		return ProductCardView(context).apply {
			setProductName(this@ProductCard.name)
			setProductDescription(this@ProductCard.description)
			setProductImage(this@ProductCard.image)
			setProductValue(this@ProductCard.value)
		}
	}
}
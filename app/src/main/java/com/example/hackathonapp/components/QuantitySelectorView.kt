package com.example.hackathonapp.components

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.example.hackathonapp.R
import kotlinx.android.synthetic.main.quantity_selector_view.view.*

class QuantitySelectorView : LinearLayout {

	private var currentValue = 0

	constructor(context: Context) : super(context)

	constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

	constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
		context,
		attrs,
		defStyleAttr
	)

	init {
		inflate(context, R.layout.quantity_selector_view, this)

		btIncrement.setOnClickListener {
			currentValue++

			if (!btDecrement.isEnabled)
				btDecrement.isEnabled = true

			changeCurrentValueText()
		}

		btDecrement.setOnClickListener {

			if (currentValue == 1) {
				currentValue--
				it.isEnabled = false
			} else {
				currentValue--
			}

			changeCurrentValueText()
		}
	}

	private fun changeCurrentValueText() {
		tvCurrentValue.text = currentValue.toString()
	}

	fun getCurrentValue(): String = tvCurrentValue.text.toString()
}
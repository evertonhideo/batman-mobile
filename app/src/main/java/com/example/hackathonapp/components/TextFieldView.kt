package com.example.hackathonapp.components

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText

class TextFieldView : EditText {

	constructor(context: Context) : super(context)

	constructor(context: Context, attrs: AttributeSet?) : super(context, attrs)

	constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(
		context,
		attrs,
		defStyleAttr
	)
}
package com.example.hackathonapp.widgets

import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.inputmethod.EditorInfo
import androidx.core.widget.doOnTextChanged
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.interfaces.StateChangeable
import br.com.zup.beagle.interfaces.WidgetState
import br.com.zup.beagle.state.Observable
import br.com.zup.beagle.widget.form.InputWidget
import com.example.hackathonapp.R
import com.example.hackathonapp.components.TextFieldView

@RegisterWidget
class TextField(
	private val placeholder: String
) : InputWidget(), StateChangeable {

	@Transient
	private lateinit var textFieldView: TextFieldView
	@Transient
	private val stateObservable = Observable<WidgetState>()

	override fun getState(): Observable<WidgetState> = stateObservable

	override fun getValue(): Any = textFieldView.text.toString()

	override fun onErrorMessage(message: String) {
		textFieldView.error = message
	}

	override fun toView(context: Context): View = TextFieldView(context).apply {
		textFieldView = this
		hint = placeholder
		setHintTextColor(Color.parseColor("#FFFFFF"))
		setTextColor(Color.parseColor("#FFFFFF"))
		background = context.getDrawable(R.drawable.bg_textfield)
		gravity = Gravity.CENTER
		imeOptions = EditorInfo.IME_ACTION_DONE
		this.doOnTextChanged { text, _, _, _ ->
			stateObservable.notifyObservers(WidgetState(text.toString()))
		}
	}
}
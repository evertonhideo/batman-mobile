package com.example.hackathonapp.widgets

import android.content.Context
import android.view.View
import androidx.core.widget.doOnTextChanged
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.interfaces.StateChangeable
import br.com.zup.beagle.interfaces.WidgetState
import br.com.zup.beagle.state.Observable
import br.com.zup.beagle.widget.form.InputWidget
import com.example.hackathonapp.components.QuantitySelectorView
import kotlinx.android.synthetic.main.quantity_selector_view.view.*

@RegisterWidget
class QuantitySelector : InputWidget(), StateChangeable {

	private val stateObservable = Observable<WidgetState>()

	override fun getState(): Observable<WidgetState> = stateObservable

	@Transient
	private lateinit var quantitySelectorView: QuantitySelectorView

	override fun onErrorMessage(message: String) {}

	override fun getValue(): Any = quantitySelectorView.getCurrentValue()

	override fun toView(context: Context): View = QuantitySelectorView(context).apply {
		quantitySelectorView = this
		tvCurrentValue.doOnTextChanged { text, _, _, _ ->
			stateObservable.notifyObservers(WidgetState(text.toString()))
		}
	}
}
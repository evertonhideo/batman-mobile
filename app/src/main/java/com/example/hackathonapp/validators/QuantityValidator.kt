package com.example.hackathonapp.validators

import br.com.zup.beagle.annotation.RegisterValidator
import br.com.zup.beagle.form.Validator
import com.example.hackathonapp.widgets.QuantitySelector


@RegisterValidator("quantityValidator")
class QuantityValidator : Validator<String, QuantitySelector> {
	override fun isValid(input: String, widget: QuantitySelector): Boolean = input.toInt() > 0
}
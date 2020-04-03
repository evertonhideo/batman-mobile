package com.example.hackathonapp.validators

import br.com.zup.beagle.annotation.RegisterValidator
import br.com.zup.beagle.form.Validator
import com.example.hackathonapp.widgets.TextField

@RegisterValidator("userValidator")
class EmptyValueValidator : Validator<String, TextField> {

	override fun isValid(input: String, widget: TextField): Boolean {
		return input.isNotEmpty()
	}
}
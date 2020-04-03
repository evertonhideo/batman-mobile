package com.example.hackathonapp.config

import br.com.zup.beagle.annotation.BeagleComponent
import br.com.zup.beagle.setup.DesignSystem
import com.example.hackathonapp.R

@BeagleComponent
class AppDesignSystem : DesignSystem {

	override fun buttonStyle(name: String): Int {
		return when (name) {
			"DesignSystem.Button.Login" -> R.style.DesignSystem_Button_Login
			"Design.Button.secondary" -> R.style.DesignSystem_Button_Secondary
			"Design.Button.login" -> R.style.DesignSystem_Button_Login
			else -> R.style.DesignSystem_Button_Primary
		}
	}

	override fun image(name: String): Int {
		return when(name) {
			"SuccessEmoji" -> R.drawable.ic_success
			"FailEmoji" -> R.drawable.ic_error
			"Cart" -> R.drawable.ic_cart
			else -> R.drawable.ic_launcher_background
		}
	}

	override fun textAppearance(name: String): Int {
		return when (name) {
			"Design.TextAppearance.H1" -> R.style.DesignSystem_Text_H1
			"Design.TextAppearance.H2" -> R.style.DesignSystem_Text_H2
			else -> R.style.DesignSystem_Text_H3
		}
	}

	override fun theme(): Int {
		return R.style.AppTheme
	}

	override fun toolbarStyle(name: String): Int {
		return R.style.DesignSystem_Toolbar
	}
}
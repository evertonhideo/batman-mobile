package com.example.hackathonapp.feature.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.beagle.ext.unitReal
import br.com.zup.beagle.utils.toView
import br.com.zup.beagle.widget.core.EdgeValue
import br.com.zup.beagle.widget.core.Flex
import br.com.zup.beagle.widget.core.Size
import br.com.zup.beagle.widget.form.Form
import br.com.zup.beagle.widget.form.FormInput
import br.com.zup.beagle.widget.form.FormMethodType
import br.com.zup.beagle.widget.form.FormSubmit
import br.com.zup.beagle.widget.layout.Container
import br.com.zup.beagle.widget.ui.Button
import com.example.hackathonapp.R
import com.example.hackathonapp.widgets.TextField
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

	companion object {
		fun newIntent(context: Context) = Intent(context, LoginActivity::class.java)
	}

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)

		setContentView(R.layout.activity_login)

		container.addView(buildView())
	}

	private fun buildView(): View {

		return Form(
			path = "/login",
			method = FormMethodType.POST,
			child = Container(
				children = listOf(
					FormInput(
						name = "username",
						required = true,
						validator = "userValidator",
						errorMessage = "Invalid user",
						child = TextField("Insert yout user").setId("tfUser").applyFlex(
							Flex(
								size = Size(height = 70.unitReal())
							)
						)
					),
					FormSubmit(
						enabled = false,
						child = Button("Login", style = "DesignSystem.Button.Login")
							.applyFlex(
								Flex(
									margin = EdgeValue(top = 15.unitReal()),
									size = Size(height = 70.unitReal())
								)
							)
					)
				)
			)
		).toView(this)
	}
}

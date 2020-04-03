package com.example.hackathonapp.widgets

import android.content.Context
import android.view.View
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.WidgetView
import com.example.hackathonapp.components.GradientView

@RegisterWidget
class GradientWidget : WidgetView() {
	override fun toView(context: Context): View = GradientView(context)
}
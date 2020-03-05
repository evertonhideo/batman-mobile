package com.example.marketitiplace.widgets

import android.content.Context
import android.view.View
import br.com.zup.beagle.annotation.RegisterWidget
import br.com.zup.beagle.widget.core.WidgetView
import com.example.marketitiplace.ContadorComponent
import com.example.marketitiplace.ProductComponent

@RegisterWidget
class CounterWidget : WidgetView() {

    override fun toView(context: Context): View = ContadorComponent(context)
}
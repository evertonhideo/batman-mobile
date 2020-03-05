package com.example.marketitiplace

import android.content.Context
import android.util.AttributeSet
import android.widget.ImageButton
import android.widget.LinearLayout
import android.widget.TextView



class ContadorComponent: LinearLayout {


    constructor (context: Context): super(context)

    constructor (context: Context , attrs: AttributeSet): super(context, attrs)

    init {

        inflate(context, R.layout.contador_view, this)

        var imgbtn : ImageButton = findViewById(R.id.botaoMenos)
        val text =  findViewById<TextView>(R.id.value)
        val imgbtn1 = findViewById<ImageButton>(R.id.botaoMais)

        imgbtn.setOnClickListener {
            var value = Integer.parseInt(text.text.toString())
            if (value != 1) {
                text.setText((value - 1).toString())
            }
        }
        imgbtn1.setOnClickListener {
            var value = Integer.parseInt(text.text.toString())
            print(value)
            text.setText((value + 1).toString())
        }

    }
}

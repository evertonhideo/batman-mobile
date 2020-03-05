package com.example.marketitiplace

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import br.com.zup.beagle.view.BeagleActivity
import br.com.zup.beagle.view.ScreenRequest

class LoginActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val loginButton = findViewById<Button>(R.id.btnSubmitLogin)
        loginButton.setOnClickListener {
            val request = ScreenRequest("/productList")
            val intent = BeagleActivity.newIntent(this, request)
            startActivity(intent)
        }
    }



}
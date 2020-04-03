package com.example.hackathonapp.feature.splash

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.hackathonapp.feature.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startActivity(LoginActivity.newIntent(this))
        finish()
    }

}

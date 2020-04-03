package com.example.hackathonapp

import android.app.Application
import com.example.hackathonapp.config.BeagleSetup

class HackathonApp: Application() {

    override fun onCreate() {
        super.onCreate()

        BeagleSetup().init(this)
    }
}
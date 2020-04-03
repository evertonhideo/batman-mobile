package com.example.hackathonapp.di

import okhttp3.OkHttpClient

object NetworkProvider {

	val okHttpClient: OkHttpClient by lazy {
		OkHttpClient.Builder().build()
	}

}
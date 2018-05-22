package com.example.jaime.pruebakotlin.Activities

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

class SplashActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        getSupportActionBar()?.hide()
        Thread.sleep(3000)
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
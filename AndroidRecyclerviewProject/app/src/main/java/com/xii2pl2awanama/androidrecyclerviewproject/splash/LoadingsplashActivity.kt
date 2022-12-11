package com.xii2pl2awanama.androidrecyclerviewproject.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.xii2pl2awanama.androidrecyclerviewproject.LoginActivity
import com.xii2pl2awanama.androidrecyclerviewproject.R

class LoadingsplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loadingsplash)

        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        },1000)
    }
}
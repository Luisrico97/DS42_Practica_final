package com.rimomo.finalprojet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView

class splashactivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splashactivity)

        val funciontime = Handler(Looper.getMainLooper())
        val time: Long = 2000

        funciontime.postDelayed({
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)

            finish()

        }, time)
    }
}
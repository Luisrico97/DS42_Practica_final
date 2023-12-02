package com.rimomo.finalprojet
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.ImageView


class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val logo = findViewById<ImageView>(R.id.logo);
        val funciontime = Handler(Looper.getMainLooper())
        val time: Long = 2000


        funciontime.postDelayed({
            val i = Intent(this, AuthActivity::class.java)
            startActivity(i)

            finish()

        }, time)
    }
}
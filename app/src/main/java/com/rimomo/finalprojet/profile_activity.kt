package com.rimomo.finalprojet

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class profile_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)



        val BtnProfile = findViewById<Button>(R.id.InsertMoney)
        val Editmoney = findViewById<EditText>(R.id.MoneyEdit)
        val Progress = findViewById<ProgressBar>(R.id.progressBar)

        BtnProfile.setOnClickListener {
            val value = Editmoney.text.toString()
            val progressValue = value.toIntOrNull() ?: 0
            Progress.progress = progressValue
        }


    }
}

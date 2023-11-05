package com.rimomo.finalprojet

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.ViewFlipper

class MainActivity : AppCompatActivity() {

    private val imageList = arrayListOf(
        R.drawable.logo,
        R.drawable.menudo,
        R.drawable.pozole
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewFlipper = findViewById<ViewFlipper>(R.id.view_eat)
        val inAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left)
        val outAnimation = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right)



        viewFlipper.inAnimation = inAnimation
        viewFlipper.outAnimation = outAnimation

        for (image in imageList){
            val imageView = ImageView(this)
            imageView.setImageResource(image)
            imageView.layoutParams = RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.MATCH_PARENT,
            )
            viewFlipper.addView(imageView)

        }
    }
}
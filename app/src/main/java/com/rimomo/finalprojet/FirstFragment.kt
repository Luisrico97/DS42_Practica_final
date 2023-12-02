package com.rimomo.finalprojet

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.ImageView
import android.widget.ViewFlipper
import androidx.navigation.NavController
import androidx.navigation.Navigation

class FirstFragment : Fragment() {

    private val imageList = arrayListOf(
        R.drawable.logo,
        R.drawable.menudo,
        R.drawable.pozole,
        R.drawable.asada,
        R.drawable.chimichanga,
        R.drawable.guacamole,
        R.drawable.flautas
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_first, container, false)

        val viewFlipper = view.findViewById<ViewFlipper>(R.id.view_eat)
        val inAnimation = AnimationUtils.loadAnimation(requireContext(), android.R.anim.slide_in_left)
        val outAnimation = AnimationUtils.loadAnimation(requireContext(), android.R.anim.slide_out_right)
        val Btnprofile = view.findViewById<Button>(R.id.profile)
        val list = view.findViewById<Button>(R.id.list1)

        viewFlipper.inAnimation = inAnimation
        viewFlipper.outAnimation = outAnimation

        for (image in imageList){
            val imageView = ImageView(requireContext())
            imageView.setImageResource(image)
            imageView.layoutParams = ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
            )
            viewFlipper.addView(imageView)
        }


        Btnprofile.setOnClickListener {
            val controller : NavController =
                Navigation.findNavController(view)
            controller.navigate(
                R.id.action_firstFragment_to_secondFragment)
        }



        list.setOnClickListener {
           val controller : NavController =
               Navigation.findNavController(view)
           controller.navigate(
                R.id.action_firstFragment_to_listFragment)
        }

        return view
    }
}
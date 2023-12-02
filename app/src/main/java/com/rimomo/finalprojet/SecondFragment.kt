package com.rimomo.finalprojet

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast

class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_second, container, false)

        val BtnProfile = view.findViewById<Button>(R.id.InsertMoney)
        val Editmoney = view.findViewById<EditText>(R.id.MoneyEdit)
        val ProgressM = view.findViewById<ProgressBar>(R.id.progressBar)
        val textProgress = view.findViewById<TextView>(R.id.totaltext)
        val clientTextView = view.findViewById<TextView>(R.id.Client)


        
        ProgressM.max = 1000
        var currentProgress = 0

        BtnProfile.setOnClickListener {
            val inputMoney = Editmoney.text.toString().toDoubleOrNull()

            if (inputMoney != null && inputMoney in 1.0..1000.0) {
                val progressValue = inputMoney.toInt()

                val remainingProgress = ProgressM.max - currentProgress
                val finalProgress = if (remainingProgress >= progressValue) {
                    currentProgress += progressValue
                    currentProgress
                } else {
                    currentProgress = ProgressM.max
                    ProgressM.max
                }

                ProgressM.progress = finalProgress
                textProgress.text = "Saldo agregado: $finalProgress"

                when (finalProgress) {
                    1000 -> Toast.makeText(requireContext(), "Haz obtenido un cupon de $400.", Toast.LENGTH_LONG).show()
                    250 -> Toast.makeText(requireContext(), "Haz obtenido una bebida GRATIS", Toast.LENGTH_LONG).show()
                    500 -> Toast.makeText(requireContext(), "Haz obtenido un postre GRATIS", Toast.LENGTH_LONG).show()
                    700 -> Toast.makeText(requireContext(), "Haz obtenido una platillo GRATIS", Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(requireContext(), "Ingresa un número válido del 1 al 1000", Toast.LENGTH_SHORT).show()
            }

            Log.d("ProgressBar", "InputMoney: $inputMoney")
        }

        return view
    }

}
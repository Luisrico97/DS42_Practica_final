package com.rimomo.finalprojet

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class CountryAdapter(private var countries: List<Country>): RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {

        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_country, parent, false)
        return CountryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val country = countries[position]
        holder.render(country)

        //aquí se aplica la lógica. ej: onClickListener
    }

    override fun getItemCount(): Int {
        return countries.size
    }

    class CountryViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name: TextView = view.findViewById(R.id.eat_name)
        val capital: TextView = view.findViewById(R.id.description_eat)
        val continent: TextView = view.findViewById(R.id.price_eat)

        val image: ImageView = view.findViewById(R.id.eat_image)

        fun render(country: Country) {
            name.text = country.name + ", "
            capital.text = country.capital
            continent.text = country.continent
            val imageResource = when (country.image) {
                "asada" -> R.drawable.asada
                "chimichangas" -> R.drawable.chimichanga
                "flautas" -> R.drawable.flautas
                "guacamole" -> R.drawable.guacamole
                "menudo" -> R.drawable.menudo
                "pozole" -> R.drawable.pozole
                "quesadillas" -> R.drawable.quesadillas
                "tamales" -> R.drawable.tamales
                else -> R.drawable.default_image
            }
            Picasso.get().load(imageResource).into(image)
        }
    }
}
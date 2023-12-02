package com.rimomo.finalprojet
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListFragment : Fragment() {

    private var countries : List<Country> = emptyList()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)

        initData()
        val recyclerView =
            view.findViewById<RecyclerView>(
                R.id.countriesRecycler
            )
        val adapter = CountryAdapter(countries)
        //Lista anchura completa
        val layoutManager = LinearLayoutManager(container?.context)
        //Cuadricula 2X2
        //val gridLayoutManager = GridLayoutManager(container?.context, 2)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return view
    }

    private fun initData() {

        countries = listOf(
            Country(1, "Tacos de Asada", "Carne asada, salsa, guacamole", "$46", "asada"),
            Country(2, "Orden de Chimichangas", "Papa, Crema, verdura, salsa", "$80", "chimichangas"),
            Country(3,"Orden de Flautas","Pollo, Crema, verdura, salsa","$60", "flautas"),
            Country(4, "Guacamole", "Salsa bandera, aguacate", "$45", "guacamole"),
            Country(5, "Menudo", "Panza de res, Grano, Cilandro, Cebolla", "$120", "menudo"),
            Country(6, "Pozole", "Carne de res, Grano, Lechuga, Cebolla", "$112", "pozole"),
            Country(7,"Quesadillas", "Queso con chiltepin", "$25", "quesadillas"),
            Country(8, "Tamales", "Carne o Elote", "$17", "tamales")
        )
    }
}
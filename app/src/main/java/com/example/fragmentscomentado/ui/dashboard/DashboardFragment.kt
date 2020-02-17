package com.example.fragmentscomentado.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.fragmentscomentado.R

class DashboardFragment : Fragment() {

    //Para usar lo creado en en viewModel
    private lateinit var dashboardViewModel: DashboardViewModel
  //Este es el fragment del dashboard, aqui se realiza el paso de llamar lo que vamos dentro del
  //propio fragment usando el get de la clase dashboardViewModel para obtener lo que hay dentro
  //El resto de fragment son exactamente igual solo que cambian el layout que cogen y el texto
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProviders.of(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        val textView: TextView = root.findViewById(R.id.text_dashboard)
        dashboardViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }
}
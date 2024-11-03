package com.juanfra.tablayoutejemplo

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.tabs.TabLayout

/*
Autor: Juan Francisco Sánchez González
Fecha: 03/11/2024
Clase: Actividad que contiene un TabLayout y un BottomNavigationView con sus respectivos manejadores
de eventos.
*/

class MainActivity : AppCompatActivity() {

    lateinit var tabLayout: TabLayout
    lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Instanciar el TabLayout y se añaden las pestañas
        tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab1_text)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab2_text)))
        tabLayout.addTab(tabLayout.newTab().setText(getString(R.string.tab3_text)))

        // Agregar el listener para eventos de selección de pestañas
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {

            // Se llama cuando una pestaña es seleccionada
            override fun onTabSelected(tab: TabLayout.Tab?) {
                tab?.let {
                    // Código para ejecutar
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.tab_sel_text, it.text),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            // Se llama cuando una pestaña es des-seleccionada
            override fun onTabUnselected(tab: TabLayout.Tab?) {
                tab?.let {
                    // Código para ejecutar
                }
            }

            // Se llama cuando una pestaña es seleccionada de nuevo (cuando ya estaba seleccionada)
            override fun onTabReselected(tab: TabLayout.Tab?) {
                tab?.let {
                    // Código para ejecutar
                }
            }
        })

        // Configurar el BottomNavigationView
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.nav_view)
        // Configura el listener de selección para el BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    Toast.makeText(this, getString(R.string.navbutton_home_text), Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.navigation_dashboard -> {
                    Toast.makeText(this, getString(R.string.navbutton_dashboard_text), Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.navigation_notifications -> {
                    Toast.makeText(this, getString(R.string.navbutton_notifications_text), Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }
    }
}
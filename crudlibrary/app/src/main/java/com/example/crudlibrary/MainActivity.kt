package com.example.crudlibrary

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        var btnLibro =
            findViewById<Button>(R.id.btnLibro)

        var btnNuevoLibro =
            findViewById<Button>(R.id.btnNuevoLibro)

        var btndetalleLibro =
            findViewById<Button>(R.id.btnDetalleLibro)

        btnLibro.setOnClickListener {
            crudlibrary(1)
        }

        btnNuevoLibro.setOnClickListener {
            crudlibrary(2)
        }

        btndetalleLibro.setOnClickListener {
            crudlibrary(3)
        }



    }

    private fun crudlibrary(position: Int) {
        val fragment: Fragment = when (position) {
            1 -> listaLibro()
            2 -> guardarLibro()
            3 -> detalleLibro()

            else -> listaLibro()
        }
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.FCV, fragment)
        fragmentTransaction.commit()

    }
}
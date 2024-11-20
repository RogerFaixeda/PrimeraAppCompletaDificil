package com.faixeda.primeraappcompleta

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import com.faixeda.primeraappcompleta.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.spinnerCurs.adapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.cursos))

        //Boto afegir
        binding.buttonAfegir.setOnClickListener{
            if(binding.editTextNom.text.isNotEmpty() && binding.editTextEdat.text.isNotEmpty()){
                Datasource.addAlumne(
                    binding.editTextNom.text.toString(),
                    binding.editTextEdat.text.toString().toInt(),
                    binding.spinnerCurs.selectedItem.toString()
                )
                Toast.makeText(this, "S'ha afegit l'alumne " + binding.editTextNom, Toast.LENGTH_SHORT).show()
                binding.editTextNom.text?.clear()
                binding.editTextEdat.text?.clear()
            } else {
                Toast.makeText(this, "Has d'omplir tots els camps", Toast.LENGTH_SHORT).show()
            }
        }

        //Boto seguent
        binding.buttonSeguent.setOnClickListener{
            val intent = Intent(applicationContext, LlistatAlumnes::class.java)
            startActivity(intent)
        }
    }
}
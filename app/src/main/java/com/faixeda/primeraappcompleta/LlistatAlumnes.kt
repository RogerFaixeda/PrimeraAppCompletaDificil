package com.faixeda.primeraappcompleta

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.faixeda.primeraappcompleta.databinding.ActivityActivitat2Binding

class LlistatAlumnes : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val binding: ActivityActivitat2Binding = DataBindingUtil.setContentView(this, R.layout.activity_activitat2)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.spinnerSelectCurs.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item,
            resources.getStringArray(R.array.cursos))

        binding.buttonExit.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val recyclerView = binding.recyclerview
        recyclerView.layoutManager = LinearLayoutManager(this)

        fun actualitzarAlumnes() {
            val alumnes = Datasource.getAlumneFromCurs(binding.spinnerSelectCurs.selectedItem.toString())
            val adapter = Adapter(alumnes)
            recyclerView.adapter = adapter
        }

        actualitzarAlumnes()

        binding.spinnerSelectCurs.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                actualitzarAlumnes()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {
            }
        }

    }
}
package com.liceolapaz.dam.ej1rcv

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.liceolapaz.dam.ej1rcv.databinding.ActivityAddPlayerBinding
import com.liceolapaz.dam.ej1rcv.databinding.ActivityPlayerListBinding

class AddPlayerActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddPlayerBinding
    lateinit var playersDBHelper: miSQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_player)
        playersDBHelper = miSQLiteHelper(this)

        binding = ActivityAddPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var playerPositions = arrayOf("Portero(PT)", "Defensa(DF)", "Mediocampista(MC)", "Delantero(DL)")
        val positionSpinner = findViewById<Spinner>(R.id.spPlayerPosition)
        // Set the how to display it
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, playerPositions)
        // Set the view to display when the list of choices appear
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        positionSpinner.adapter = adapter
    }
}
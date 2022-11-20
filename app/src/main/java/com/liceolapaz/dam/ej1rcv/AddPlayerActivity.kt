package com.liceolapaz.dam.ej1rcv

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
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

        // Extract the player code from the intent
        var playerCode = intent.getIntExtra("playerCode", 1)
        if (playerCode == 0) {
            playerCode = 1
        }

        binding = ActivityAddPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var playerPositions = arrayOf("Portero(PT)", "Defensa(DF)", "Mediocampista(MC)", "Delantero(DL)")
        val positionSpinner = findViewById<Spinner>(R.id.spPlayerPosition)
        val codeTxt = findViewById<EditText>(R.id.etPlayerCode)
        codeTxt.isEnabled = false
        codeTxt.setText(playerCode.toString())

        // Set the how to display it
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, playerPositions)
        // Set the view to display when the list of choices appear
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        positionSpinner.adapter = adapter

        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener{
            var newPlayerCode = binding.etPlayerCode.text.toString().toInt()
            var newPlayerName = binding.etPlayerName.text.toString()
            var newPlayerPrice = binding.etPlayerPrice.text.toString().toDouble()
            var newPlayerPosition = binding.spPlayerPosition.selectedItem.toString()
            var newPlayerPoints = binding.etPlayerPoints.text.toString().toInt()

            val player = Player(newPlayerCode, newPlayerName, newPlayerPrice, newPlayerPosition, newPlayerPoints)
            playersDBHelper.insertPlayer(player)

            //  send the player to the list
            val intent = Intent(this, PlayerListActivity::class.java)

            intent.putExtra("player", player)
            startActivity(intent)
        }
    }
}
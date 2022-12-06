package com.liceolapaz.dam.ej1rcv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import com.liceolapaz.dam.ej1rcv.databinding.ActivityAddPlayerBinding
import com.liceolapaz.dam.ej1rcv.databinding.ActivityEditPlayerBinding

class EditPlayerActivity : AppCompatActivity() {
    lateinit var binding : ActivityEditPlayerBinding
    lateinit var playersDBHelper: miSQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_player)
        val playerCode = intent.getIntExtra("playerCode", 0)
        val playerName = intent.getStringExtra("playerName")
        val playerPrice = intent.getDoubleExtra("playerPrice", 0.0)
        val playerPosition = intent.getStringExtra("playerPosition")
        val playerPoints = intent.getIntExtra("playerPoints", 0)

        //DB Helper
        playersDBHelper = miSQLiteHelper(this)

        //Binding
        binding = ActivityEditPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Player Code
        val etPlayerCode = findViewById<EditText>(R.id.etPlayerCode)
        etPlayerCode.setText(playerCode.toString())
        etPlayerCode.isEnabled = false

        // Player Name
        val etPlayerName = findViewById<EditText>(R.id.etPlayerName)
        etPlayerName.setText(playerName)

        // Player Price
        val etPlayerPrice = findViewById<EditText>(R.id.etPlayerPrice)
        etPlayerPrice.setText(playerPrice.toString())

        // Player Position
        var playerPositions = arrayOf("Portero(PT)", "Defensa(DF)", "Mediocampista(MC)", "Delantero(DL)")
        val positionSpinner = findViewById<Spinner>(R.id.spPlayerPosition)
        // Set the how to display it
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, playerPositions)
        // Set the view to display when the list of choices appear
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        // Apply the adapter to the spinner
        positionSpinner.adapter = adapter
        //set select by default the player position
        positionSpinner.setSelection(playerPositions.indexOf(playerPosition))

        // Player Points
        val etPlayerPoints = findViewById<EditText>(R.id.etPlayerPoints)
        etPlayerPoints.setText(playerPoints.toString())

        // Save button
        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener{
            // show confirmation message if user wants to save the player
            var builder = android.app.AlertDialog.Builder(this)
            builder.setTitle("Confirmación")
            builder.setMessage("¿Desea guardar el jugador?")
            // confirm, cancel buttons
            builder.setPositiveButton("Confirmar") { dialog, which ->
                // save the player
                var newPlayerCode = binding.etPlayerCode.text.toString().toInt()
                var newPlayerName = binding.etPlayerName.text.toString()
                var newPlayerPrice = binding.etPlayerPrice.text.toString().toDouble()
                var newPlayerPosition = binding.spPlayerPosition.selectedItem.toString()
                var newPlayerPoints = binding.etPlayerPoints.text.toString().toInt()

                val player = Player(newPlayerCode, newPlayerName, newPlayerPrice, newPlayerPosition, newPlayerPoints)
                playersDBHelper.updatePlayer(player)

                //  send the player to the list
                val intent = Intent(this, PlayerListActivity::class.java)

                intent.putExtra("player", player)
                startActivity(intent)
            }

            builder.setCancelable(true)
            builder.setNegativeButton("No") { dialog, which ->
                finish()
            }
            builder.setNeutralButton("Cancelar") { dialog, which ->
                //nothing
            }

            builder.create().show()

        }
    }
}
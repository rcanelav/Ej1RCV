package com.liceolapaz.dam.ej1rcv

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import com.liceolapaz.dam.ej1rcv.databinding.ActivityPlayerListBinding

class PlayerListActivity : AppCompatActivity() {
    lateinit var binding : ActivityPlayerListBinding
    lateinit var playersDBHelper: miSQLiteHelper
    var players = ArrayList<Player>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_list)

        val playersDBHelper = miSQLiteHelper(this )
        val db = playersDBHelper
        players = db.readPlayers()

        binding = ActivityPlayerListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (player in players) {
            println(player)
        }

        // Search in the players the one with the highest code
        var highestCode = 0
        for (player in players) {
            if (player.code > highestCode) {
                highestCode = player.code + 1
            }
        }

        val btnAddPlayer = findViewById<Button>(R.id.btnAddPlayer)
        btnAddPlayer.setOnClickListener{
            val intent = Intent(this, AddPlayerActivity::class.java)
            intent.putExtra("playerCode", highestCode)
            startActivity(intent)
        }
    }
}
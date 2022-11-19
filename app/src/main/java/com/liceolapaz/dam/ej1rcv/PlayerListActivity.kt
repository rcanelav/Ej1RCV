package com.liceolapaz.dam.ej1rcv

import android.content.Intent
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.liceolapaz.dam.ej1rcv.databinding.ActivityPlayerListBinding

class PlayerListActivity : AppCompatActivity() {
    lateinit var binding : ActivityPlayerListBinding
    lateinit var playersDBHelper: miSQLiteHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_player_list)

        val playersDBHelper = miSQLiteHelper(this )
        val db = playersDBHelper
        val players = db.readPlayers()

        binding = ActivityPlayerListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        for (player in players) {
            println(player)
        }

        val btnAddPlayer = findViewById<Button>(R.id.btnAddPlayer)
        btnAddPlayer.setOnClickListener{

            val intent = Intent(this, AddPlayerActivity::class.java)
            startActivity(intent)
        }
    }
}
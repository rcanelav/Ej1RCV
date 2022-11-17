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
        playersDBHelper = miSQLiteHelper(this)

//        val db : SQLiteDatabase = playersDBHelper.readableDatabase
//        val cursor = db.rawQuery("SELECT * FROM players", null)

//        if (cursor.moveToFirst()) {
//            do {
//                val name = cursor.getString(1)
//                val surname = cursor.getString(2)
//                val position = cursor.getString(3)
//                val number = cursor.getInt(4)
//                val team = cursor.getString(5)
//
//            } while (cursor.moveToNext())
//        }
        binding = ActivityPlayerListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val addPlayerBtn = findViewById<Button>(R.id.btnAddPlayer)
        addPlayerBtn.setOnClickListener {
            val intent = Intent(this, AddPlayerActivity::class.java)
            startActivity(intent)
        }


    }
}
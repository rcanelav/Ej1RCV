package com.liceolapaz.dam.ej1rcv

import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }
}
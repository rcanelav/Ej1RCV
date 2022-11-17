package com.liceolapaz.dam.ej1rcv

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.text.set
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<EditText>(R.id.etUser).setText("admin")
        findViewById<EditText>(R.id.etPassword).setText("liceo")
        var tries = 0;
        val loginButton = findViewById<Button>(R.id.btnLogin);
        loginButton.setOnClickListener{
            val username = findViewById<EditText>(R.id.etUser).text.toString()
            val password = findViewById<EditText>(R.id.etPassword).text.toString()
            val errorMessage = findViewById<TextView>(R.id.txtError)

            println("Username: $username")
            println("Password: $password")

            if (username == "admin" && password == "liceo") {
                val intent = Intent(this, PlayerListActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Invalid credentials", Toast.LENGTH_SHORT).show()
                print(tries)
                errorMessage.setVisibility(View.VISIBLE)
                if (++tries == 3) {
                    exitProcess(0)
                }
            }
        }
    }
}
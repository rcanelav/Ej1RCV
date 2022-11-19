package com.liceolapaz.dam.ej1rcv

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class miSQLiteHelper(context: Context) : SQLiteOpenHelper(
    context, "jugadores", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE jugadores +" +
                "(codigo INTEGER PRIMARY KEY AUTOINCREMENT +" +
                ", nombre TEXT, precio DECIMAL, posicion TEXT, puntos INTEGER)"
        db!!.execSQL(createTable)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS jugadores")
        onCreate(db)
    }

    fun insertPlayer( player: Player) {
        val db = this.writableDatabase
        db.execSQL("INSERT INTO jugadores (nombre, precio, posicion, puntos) VALUES ('${player.name}', ${player.price}, '${player.position}', ${player.points})")
        db.close()
    }

    fun readPlayers(): ArrayList<Player> {
        val players = ArrayList<Player>()
        val db = this.readableDatabase
        val cursor = db.rawQuery("SELECT * FROM jugadores", null)
        if (cursor.moveToFirst()) {
            do {
//                val codigo = cursor.getInt(0)
                val nombre = cursor.getString(1)
                val precio = cursor.getDouble(2)
                val posicion = cursor.getString(3)
                val puntos = cursor.getInt(4)
                players.add(Player(nombre, precio, posicion, puntos))
            } while (cursor.moveToNext())
        }
        cursor.close()
        db.close()
        return players
    }
}

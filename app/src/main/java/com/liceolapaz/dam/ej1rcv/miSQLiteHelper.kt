package com.liceolapaz.dam.ej1rcv

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class miSQLiteHelper(context: Context) : SQLiteOpenHelper(
    context, "jugadores", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE jugadores " +
                "(codigo INTEGER PRIMARY KEY AUTOINCREMENT " +
                ", nombre TEXT, precio DECIMAL, posicion TEXT, puntos INTEGER)"
        db!!.execSQL(createTable)
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS jugadores")
        onCreate(db)
    }

    fun insertPlayer( player: Player) {
        val db = this.writableDatabase
        // check if table exists
        // Verify if table exists
        var cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='jugadores'", null)
        if (cursor.count == 0) {
            // table doesn't exist
            onCreate(db)
        }
        db.execSQL("INSERT INTO jugadores (nombre, precio, posicion, puntos) VALUES ('${player.name}', ${player.price}, '${player.position}', ${player.points})")

    }

    fun readPlayers(): ArrayList<Player> {
        val players = ArrayList<Player>()
        val db = this.readableDatabase

        // Verify if table exists
        var cursor = db.rawQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='jugadores'", null)
        if (cursor.count == 0) {
            println("Table does not exist")
            return players
        }
        cursor = db.rawQuery("SELECT * FROM jugadores", null)

        if (cursor.moveToFirst()) {
            do {
                val code = cursor.getInt(0)
                val name = cursor.getString(1)
                val price = cursor.getDouble(2)
                val position = cursor.getString(3)
                val points = cursor.getInt(4)
                players.add(Player(code, name, price, position, points))
            } while (cursor.moveToNext())
        }

        return players
    }
}

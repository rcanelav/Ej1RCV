package com.liceolapaz.dam.ej1rcv

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class miSQLiteHelper(context: Context) : SQLiteOpenHelper(
    context, "jugadores.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE jugadores (codigo INTEGER, nombre TEXT, precio DECIMAL, posicion TEXT, puntos INTEGER)")
    }
    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS jugadores")
        onCreate(db)
    }

    fun insertPlayer(codigo: Int, nombre: String, precio: Double, posicion: String, puntos: Int) {
        val data = ContentValues()
        data.put("codigo", codigo)
        data.put("nombre", nombre)
        data.put("precio", precio)
        data.put("posicion", posicion)
        data.put("puntos", puntos)

        val db = this.writableDatabase
        db.insert("jugadores", null, data)
        db.close()
    }
}

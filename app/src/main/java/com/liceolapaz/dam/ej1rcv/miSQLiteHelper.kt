package com.liceolapaz.dam.ej1rcv

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class miSQLiteHelper(context: Context) : SQLiteOpenHelper(
    context, "jugadores.db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        db!!.execSQL("CREATE TABLE jugadores (codigo INTEGER, nombre TEXT, precio DECIMAL, posicion TEXT, puntos INTEGER)")
    }
    
}

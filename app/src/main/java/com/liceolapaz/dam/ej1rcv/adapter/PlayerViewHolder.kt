package com.liceolapaz.dam.ej1rcv.adapter

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liceolapaz.dam.ej1rcv.Player
import com.liceolapaz.dam.ej1rcv.R

class PlayerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val playerName = view.findViewById<TextView>(R.id.txtPlayerNameValue)
    val playerPrice = view.findViewById<TextView>(R.id.txtPlayerMoneyValue)
    val playerPosition = view.findViewById<TextView>(R.id.txtPlayerPositionValue)
    val playerPoints = view.findViewById<TextView>(R.id.txtPlayerPointsValue)

    fun render(player: Player) {
        playerName.text = player.name
        playerPrice.text = player.price.toString()
        playerPosition.text = player.position
        playerPoints.text = player.points.toString()
    }

}
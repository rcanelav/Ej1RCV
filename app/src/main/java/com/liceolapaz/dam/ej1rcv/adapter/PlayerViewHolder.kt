package com.liceolapaz.dam.ej1rcv.adapter

import android.content.Intent
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.liceolapaz.dam.ej1rcv.EditPlayerActivity
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

        itemView.setOnClickListener() {
            val intent = Intent(itemView.context, EditPlayerActivity::class.java)
            intent.putExtra("playerCode", player.code)
            intent.putExtra("playerName", player.name)
            intent.putExtra("playerPrice", player.price)
            intent.putExtra("playerPosition", player.position)
            intent.putExtra("playerPoints", player.points)


            itemView.context.startActivity(intent)
        }
    }

}
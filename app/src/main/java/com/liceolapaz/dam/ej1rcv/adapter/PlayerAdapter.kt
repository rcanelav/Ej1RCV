package com.liceolapaz.dam.ej1rcv.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.liceolapaz.dam.ej1rcv.Player
import com.liceolapaz.dam.ej1rcv.R

class PlayerAdapter(private val playerList : ArrayList<Player>) : RecyclerView.Adapter<PlayerViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        var layoutInflater = LayoutInflater.from(parent.context)

        return PlayerViewHolder(layoutInflater.inflate(R.layout.player,parent, false))
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        holder.render(playerList[position])
    }

    override fun getItemCount(): Int = playerList.size

}


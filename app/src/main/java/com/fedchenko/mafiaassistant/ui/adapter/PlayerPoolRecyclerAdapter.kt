package com.fedchenko.mafiaassistant.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fedchenko.mafiaassistant.R
import com.fedchenko.mafiaassistant.databinding.PlayerPoolRecyclerActiveItemBinding
import com.fedchenko.mafiaassistant.databinding.PlayerPoolRecyclerInactiveItemBinding
import com.fedchenko.mafiaassistant.model.Player

class PlayerPoolRecyclerAdapter : RecyclerView.Adapter<PlayerPoolBaseViewHolder>() {
    private var playersList: List<Player> = emptyList()

    val playersObserver: Observer<List<Player>> = Observer {
        val oldPlayers = playersList
        playersList = it
        val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldPlayers[oldItemPosition].id == playersList[newItemPosition].id
            }

            override fun getOldListSize(): Int {
                return oldPlayers.size
            }

            override fun getNewListSize(): Int {
                return playersList.size
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldPlayers[oldItemPosition].active == playersList[newItemPosition].active
            }
        })
        diff.dispatchUpdatesTo(this)
    }

    companion object {
        const val ACTIVE_VIEW_TYPE = 1
        const val INACTIVE_VIEW_TYPE = 2
    }

    class IllegalViewTypeException(message: String = "") : Exception(message)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerPoolBaseViewHolder {
        when (viewType) {
            ACTIVE_VIEW_TYPE -> {
                val binding: PlayerPoolRecyclerActiveItemBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.player_pool_recycler_active_item,
                    parent,
                    false
                )
                return PlayerPoolBaseViewHolder.PlayerPoolActiveViewHolder(binding)
            }
            INACTIVE_VIEW_TYPE -> {
                val binding: PlayerPoolRecyclerInactiveItemBinding = DataBindingUtil.inflate(
                    LayoutInflater.from(parent.context),
                    R.layout.player_pool_recycler_inactive_item,
                    parent,
                    false
                )
                return PlayerPoolBaseViewHolder.PlayerPoolInactiveViewHolder(binding)
            }
            else ->
                throw IllegalViewTypeException("Unknown view type $viewType")
        }
    }

    override fun getItemCount(): Int = playersList.size

    override fun getItemViewType(position: Int): Int =
        if (playersList[position].active) ACTIVE_VIEW_TYPE else INACTIVE_VIEW_TYPE

    override fun onBindViewHolder(holder: PlayerPoolBaseViewHolder, position: Int) {
        when (holder) {
            is PlayerPoolBaseViewHolder.PlayerPoolActiveViewHolder -> {
                holder.binding.player = playersList[position]
            }
            is PlayerPoolBaseViewHolder.PlayerPoolInactiveViewHolder -> {
                holder.binding.player = playersList[position]
            }
        }
    }
}
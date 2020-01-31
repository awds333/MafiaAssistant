package com.fedchenko.mafiaassistant.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.fedchenko.mafiaassistant.databinding.PlayerPoolRecyclerActiveItemBinding
import com.fedchenko.mafiaassistant.databinding.PlayerPoolRecyclerInactiveItemBinding

sealed class PlayerPoolBaseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    class PlayerPoolActiveViewHolder(val binding: PlayerPoolRecyclerActiveItemBinding) :
        PlayerPoolBaseViewHolder(binding.root)

    class PlayerPoolInactiveViewHolder(val binding: PlayerPoolRecyclerInactiveItemBinding) :
        PlayerPoolBaseViewHolder(binding.root)
}
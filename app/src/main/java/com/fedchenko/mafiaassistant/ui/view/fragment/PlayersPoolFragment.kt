package com.fedchenko.mafiaassistant.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.fedchenko.mafiaassistant.R
import com.fedchenko.mafiaassistant.databinding.PlayerPoolFragmentLayoutBinding
import com.fedchenko.mafiaassistant.ui.adapter.PlayerPoolRecyclerAdapter
import com.fedchenko.mafiaassistant.ui.viewmodel.PlayersPoolViewModel
import kotlinx.android.synthetic.main.player_pool_fragment_layout.*
import org.koin.android.ext.android.inject

class PlayersPoolFragment : Fragment() {

    private val playersPoolViewModel: PlayersPoolViewModel by inject()

    private lateinit var binding: PlayerPoolFragmentLayoutBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.player_pool_fragment_layout,
            container,
            false
        )
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.lifecycleOwner = this
        binding.playersPoolViewModel = playersPoolViewModel
        setupAdapter()
    }

    private fun setupAdapter() {
        val adapter = PlayerPoolRecyclerAdapter()
        adapter.onItemClickListener = { view, player ->
            //TODO
        }
        playersPoolRecycler.adapter = adapter
        playersPoolViewModel.observePlayers(adapter.playersObserver, this)
    }
}
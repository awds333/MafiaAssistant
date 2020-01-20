package com.fedchenko.mafiaassistant.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.fedchenko.mafiaassistant.R
import com.fedchenko.mafiaassistant.databinding.StateChangeTimerLayouteBinding
import com.fedchenko.mafiaassistant.ui.viewmodel.TimerViewModel
import org.koin.android.ext.android.inject

class StateChangeTimerFragment : Fragment() {
    private val timerViewModel: TimerViewModel by inject()

    private lateinit var binding: StateChangeTimerLayouteBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.state_change_timer_layoute,container,false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.lifecycleOwner = this
        binding.timerViewModel = timerViewModel
    }
}